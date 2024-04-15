/**Class: NumberStats
 * @author D Browner
 * @version 1.6
 * Course: ITEC 2140 Spring 2023
 * Written: Apr 3, 2024
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NumberStats {
    public static void main(String[] args) {
        String fileName = "Book1.csv";
        String outputFileName = "stats.txt";

        try {
            // Open file for reading
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variables to store statistical values
            double sum = 0;
            double lowest = Double.MAX_VALUE;
            double highest = Double.MIN_VALUE;
            int count = 0;
            String line;

            //Read each line and process numbers
            while ((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.split(",");
                for (String number : numbers) {
                    double num = Double.parseDouble(number);
                    sum += num;
                    lowest = Math.min(lowest, num);
                    highest = Math.max(highest, num);
                    count++;
                }
            }

            //Calculate average
            double average = sum / count;

            // Close file
            bufferedReader.close();

            //write statistics to new file
            FileWriter fileWriter = new FileWriter(outputFileName);
            fileWriter.write("The sum of the numbers is: " + sum + "\n");
            fileWriter.write("The lowest number is: " + lowest + "\n");
            fileWriter.write("The highest number is: " + highest + "\n");
            fileWriter.write("The average of the numbers is: " + average + "\n");

            // Close the file writer
            fileWriter.close();

            System.out.println("Statistics written to " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}