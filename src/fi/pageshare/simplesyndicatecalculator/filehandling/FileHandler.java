
package fi.pageshare.simplesyndicatecalculator.filehandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    
    private Scanner scanner;
    private ArrayList<String> fileContent;

    public FileHandler(String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new FileReader(fileName));
        this.fileContent = new ArrayList<>();
    }
    
    public void readFile() {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                fileContent.add(line);
            }
        }
        scanner.close();
    }

    public ArrayList<String> getFileContent() {
        return fileContent;
    }
    
    
    
    
}
