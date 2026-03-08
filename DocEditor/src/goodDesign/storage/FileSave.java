package goodDesign.storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSave implements Persistence {
    @Override
    public void save(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("newFile.txt"))) {
            writer.write(data);
            System.out.println("Document saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
