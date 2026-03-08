package goodDesign;

import goodDesign.elements.DocumentElement;

import java.util.ArrayList;
import java.util.List;

public class Document {
    List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public String render() {
        StringBuilder res = new StringBuilder();

        for (DocumentElement element : documentElements) {
            res.append(element.render());
        }
        return res.toString();
    }

}
