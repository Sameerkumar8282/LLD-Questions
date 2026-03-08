package goodDesign;

import goodDesign.storage.FileSave;
import goodDesign.storage.Persistence;

public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        Persistence persistence = new FileSave();

        DocumentEditor documentEditor = new DocumentEditor(document,persistence);
        documentEditor.addText("Hello World!");
        documentEditor.addNewLine();
        documentEditor.addImage("img.jpg");
        documentEditor.addNewLine();
        documentEditor.addText("End . hh !");

        System.out.println(documentEditor.renderDocument());
        documentEditor.saveDocument();
    }
}
