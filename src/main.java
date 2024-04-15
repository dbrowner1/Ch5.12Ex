/**Class: Poem
 * @author D Browner
 * @version 1.6
 * Course: ITEC 2140 Spring 2023
 * Written: Apr 3, 2024
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Poem {
    private String name;
    private String poet;

    public Poem(String name, String poet) {
        this.name = name;
        this.poet = poet;
    }

    public String getName() {
        return name;
    }

    public String getPoet() {
        return poet;
    }
}

public class main {
    public static void main(String[] args) {
        String fileName = "poem2.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                // Alternate between name and poet
                if (count % 2 == 0) {
                    String name = line;
                    String poet = bufferedReader.readLine();
                    Poem poem = new Poem(name, poet);
                    System.out.println("Name: " + poem.getName());
                    System.out.println("Poet: " + poem.getPoet());
                }

                count++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}