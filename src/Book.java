import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Book {
    private static String title;
    private static String author;
    private static String publisher;
    private static String price;
    private static String pages;
    private static String isbn;

    public static void run(){
        try (BufferedReader reader = new BufferedReader(new FileReader("valid.txt"))){

            String info;

            while ((info = reader.readLine()) != null) {
                String[] data = info.split("-");

                if (data.length != 6){
                    System.out.println("- The field delimiter may be missing or wrong field delimiter is used.");
                } else {
                    if (!data[0].isEmpty()) {
                        title = data[0];
                    }else {
                        title = "Book title may be missing.";
                    }

                    if (!data[1].isEmpty()) {
                        author = data[1];
                    }else {
                        author = "Book author may be missing.";
                    }

                    if (!data[2].isEmpty()) {
                        publisher = data[2];
                    } else {
                        publisher = "Book publisher may be missing.";
                    }

                    if (isDouble(data[3])) {
                        price = data[3];
                    } else {
                        price = "Book price may not be a numeric value.";
                    }

                    if (isInteger(data[4])) {
                        pages = data[4];
                    } else {
                        pages = "Book price may not be a numeric value.";
                    }

                    if (!data[5].isEmpty()) {
                        isbn = data[5];
                    } else {
                        isbn = "Book ISBN may be missing.";
                    }

                    System.out.println("-----------------------------");
                    System.out.println(title + "\n" + author + "\n" + publisher + "\n" + price + "\n" + pages + "\n" + isbn);
                }
            }
        } catch (IOException e){
            System.out.println("File not found.");
        }
    }

    private static boolean isInteger(String number){
        number.replaceAll("[^0-9]", "");
        try {
            int test = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isDouble(String number){
        number.replaceAll("[^0-9]", "");
        try {
            double test = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}