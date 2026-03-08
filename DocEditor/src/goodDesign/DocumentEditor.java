package goodDesign;

import goodDesign.elements.ImageElement;
import goodDesign.elements.NewLineElement;
import goodDesign.elements.TabSpaceElement;
import goodDesign.elements.TextElement;
import goodDesign.storage.Persistence;

public class DocumentEditor {
    Document document;
    Persistence storage;
    String renderedDocument;


    public DocumentEditor(Document document,Persistence storage){
        this.document = document;
        this.storage = storage;
    }

    public void addText(String txt){
        document.addElement(new TextElement(txt));
    }
    public void addImage(String imgPath){
        document.addElement(new ImageElement(imgPath));
    }

    public void addNewLine(){
        document.addElement(new NewLineElement());
    }

    public void addNewTab(){
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument(){
        if(renderedDocument == null || renderedDocument.isEmpty()){
            renderedDocument = document.render();
        }
        return  renderedDocument;
    }

    void saveDocument(){
        storage.save(renderedDocument);
    }

}
