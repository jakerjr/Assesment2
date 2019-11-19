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

    public static void run(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String info;

            while ((info = reader.readLine()) != null) {
                String[] data = info.split("-");

                if (data.length != 6) {
                    if (data.length > 6) {
                        int missing = data.length - 6;
                        System.out.println("The field is missing " + missing + " piece/s");
                    } else {
                        int extra = 6 - data.length;
                        System.out.println("The field has an extra " + extra + " piece/s. ");
                    }
                    System.out.println("-----------------------------");
                } else {
                    if (!data[0].trim().isEmpty()) {
                        title = data[0];
                    } else {
                        title = "Book title is missing.";
                    }

                    if (!data[1].trim().isEmpty()) {
                        author = data[1].trim();
                    } else {
                        author = "Book author is missing.";
                    }

                    if (!data[2].trim().isEmpty()) {
                        publisher = data[2].trim();
                    } else {
                        publisher = "Book publisher is missing.";
                    }

                    if (isDouble(data[3])) {
                        price = data[3].trim();
                    } else {
                        price = "Book price is not a numeric value.";
                    }

                    if (isInteger(data[4])) {
                        pages = data[4].trim();
                    } else {
                        pages = "Book price is not a numeric value.";
                    }

                    if (!data[5].trim().isEmpty()) {
                        isbn = data[5].trim();
                    } else {
                        isbn = "Book ISBN is missing.";
                    }

//                    System.out.println(title + "\n" + author + "\n" + publisher + "\n" + price + "\n" + pages + "\n" + isbn);
                    System.out.format("%-15s %s", "Title: ", title);
                    System.out.format("%-16s %s", "\nAuthor: ", author);
                    System.out.format("%-16s %s", "\nPublisher: ", publisher);
                    System.out.format("%-16s %s", "\nPrice: ", price);
                    System.out.format("%-16s %s", "\nPages: ", pages);
                    System.out.format("%-16s %s", "\nISBN: ", isbn);
                    System.out.println("\n-----------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    private static boolean isInteger(String number) {
        try {
            int test = Integer.parseInt(number.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String number) {
        try {
            double test = Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}