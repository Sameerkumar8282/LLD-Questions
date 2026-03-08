package badDesign;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor(List<String> documentElements) {
        this.documentElements = documentElements;
    }

    public void addText(String text) {
        documentElements.add(text);
    }

    public void addImage(String imagePath) {
        documentElements.add(imagePath);
    }

    public String renderDocument() {
        if (renderedDocument == null || renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : documentElements) {
                if (element.endsWith(".jpg") || element.endsWith(".png")) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("document.txt"))) {
            writer.write(renderDocument());
            System.out.println("Document saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor(new ArrayList<>());
        editor.addText("Hello World");
        editor.addImage("pic.jpg");
        editor.addImage("ss.png");
        editor.addText("hehe End!");

        System.out.println(editor.renderDocument());

        editor.saveToFile();
    }
}
