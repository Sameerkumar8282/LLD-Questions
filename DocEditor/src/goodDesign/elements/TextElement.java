package goodDesign.elements;

public class TextElement implements DocumentElement {
    public String text;

    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}
