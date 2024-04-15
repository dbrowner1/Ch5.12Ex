import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PoemReader {
    private String name;
    private String poet;

    public PoemReader(String name, String poet) {
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

class Main {
    public static void main(String[] args) {
        String fileName = "poem2.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String name;
            String poet;

            while ((name = bufferedReader.readLine()) != null && (poet = bufferedReader.readLine()) != null) {
                PoemReader poem = new PoemReader(name, poet);
                System.out.println("Name: " + poem.getName());
                System.out.println("Poet: " + poem.getPoet());
                System.out.println(); // Add an empty line for clarity
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}