import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Book {
    private static String title;
    private static String author;
    private static String publisher;
    private static String price;
    private static String pages;
    private static String isbn;
    private static String info;

    public static void run(String filename) {
        Scanner input = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            boolean query = false;
            System.out.println("Do you want to search for a specific author or see all books? \n<Enter the word \"author\" or \"all\">");
            while (!query) {
                String answer = input.next().toLowerCase();
                if (answer.equals("author")){
                    System.out.println("Enter the name of the author you want to find");
                    String authorName = input.next();
                    requirement4(reader, authorName);
                    query = true;
                } else if (answer.equals("all")){
                    requirement(reader);
                    query = true;
                } else {
                    System.out.println("That may not be a valid option. Please check your spelling");
                }
            }
            requirement(reader);

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public static void requirement(BufferedReader reader) throws IOException{
        while ((info = reader.readLine()) != null) {
            String[] data = info.split("-");
            details(data);
        }
    }

    public static void requirement4(BufferedReader reader, String authorNameInput) throws IOException {
        while ((info = reader.readLine()) != null){
            String[] data = info.split("-");
            if (data[1].contains(authorNameInput)){
                details(data);
            }
        }
    }

    public static void details(String[] data) {
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

            System.out.format("%-15s %s", "Title: ", title);
            System.out.format("%-16s %s", "\nAuthor: ", author);
            System.out.format("%-16s %s", "\nPublisher: ", publisher);
            System.out.format("%-16s %s", "\nPrice: ", price);
            System.out.format("%-16s %s", "\nPages: ", pages);
            System.out.format("%-16s %s", "\nISBN: ", isbn);
            System.out.println("\n-----------------------------");
        }
    }

    public static boolean isInteger(String number) {
        try {
            int checkInteger = Integer.parseInt(number.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String number) {
        try {
            double checkDouble = Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}