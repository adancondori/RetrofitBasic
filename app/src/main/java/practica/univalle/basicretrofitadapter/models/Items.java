package practica.univalle.basicretrofitadapter.models;

public class Items {

    private int image_id;
    private String text;

    public Items(int image_id, String text) {
        this.image_id = image_id;
        this.text = text;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
