import java.util.Scanner;

/**
 * Assessment 2
 * @author Jake Galapia
 */
public class c3573954 {
    /**
     * Main method to run the program.
     * @param args No arguments used for this assessment.
     */
    public static void main(String[] args) {
        Book book = new Book();
        Scanner input = new Scanner(System.in);
        String fileName = input.next();
        book.run(fileName);
    }
}
