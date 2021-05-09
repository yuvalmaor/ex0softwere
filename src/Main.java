import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    /**
     * Prints a message according to a given grade.
     *
     * It is guaranteed that the grade is within the range [0, 100].
     *
     * @param grade The grade
     */
    public static void gradeMessage(int grade) {
        /*
        TODO: Your code for part A is here...
         */

        switch(grade/10) {
            case 10:
                System.out.println("Excellent");
                break;
            case 9:
                System.out.println("Great");
                break;
            case 8:
                System.out.println("Very Good");
                break;
            case 7:
                System.out.println("Good");
                break;
            default:
                System.out.println("OK");
        }
    }

    /**
     * Compresses a given string.
     *
     * The compression process is done by replacing a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     *
     * It is guaranteed that the string contains only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        String compressedString = "";
        int i;

        int marker=0;

        while (marker<stringToCompress.length()){
            i=1;
            marker++;

        }

        /*
        TODO: Your code for part B1 is here...
        Note: you may change the given code, but you must not change the signature of the method.
         */

        return compressedString;
    }

    /**
     * Decompresses a given string.
     *
     * The decompression process is done by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     *
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        String decompressedString = "";
        int grup=0;
        int i=0;
        int j;
        int start;
        int num;

        while (i<compressedString.length()){
            if(compressedString.charAt(i)>='0' && compressedString.charAt(i)<='9' ){
                j=i;
                start=i;
                while (j<compressedString.length()){
                    if((compressedString.charAt(j)>='0' && compressedString.charAt(j)<='9')){
                        j++;
                    }
                    else {
                        break;
                    }

                }
                if(i==j){
                    num = Integer.parseInt(compressedString.substring(i));

                }
                else {
                    //System.out.println(compressedString.substring(i, j));
                    num = Integer.parseInt(compressedString.substring(i, j));
                }
                for(int c=0;c<num;c++) {
                    decompressedString = decompressedString + compressedString.substring(grup,i);
                }
                grup=j;
                i=j;
            }

            i++;
        }
        /*
        TODO: Your code for part B2 is here...
        Note: you may change the given code, but you must not change the signature of the method.
         */

        return decompressedString;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        //System.out.println("hello");
        // Tests for part A
        int numberOfGrades = scanner.nextInt();
        for (int i = 0; i < numberOfGrades; i++) {
            int grade = scanner.nextInt();
            gradeMessage(grade);
        }

        // Tests for part B1
        int numberOfStringsToCompress = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfStringsToCompress; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            System.out.println("The compressed version of " + stringToCompress + " is " + compressedString);
        }

        // Tests for part B2
        int numberOfDecompressedStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfDecompressedStrings; i++) {
            String compressedString = scanner.nextLine();
            String decompressedString = decompressString(compressedString);
            System.out.println("The decompressed version of " + compressedString + " is " + decompressedString);
        }

        // Tests for both part B1 and B2
        int numberOfCombinedTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCombinedTests; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            String decompressedString = decompressString(compressedString);
            System.out.println("decompress(compress(" + stringToCompress + ")) == " + stringToCompress + "? " + stringToCompress.equals(decompressedString));
        }
    }
}
