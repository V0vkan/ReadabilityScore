package readability;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Checker checker = new Checker();
        FileReader fileReader = new FileReader();

        try {
            System.out.println(checker.textChecker(fileReader.readFileAsString(args[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        checker.score(scanner.next());
    }
}
