package goodDesign.elements;

public class ImageElement implements DocumentElement{
    private String imagePath;

    public ImageElement(String text){
        this.imagePath = text;
    }
    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}
