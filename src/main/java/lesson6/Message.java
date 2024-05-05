package lesson6;

public class Message {

    private long id;
    private String text;
    private String author;

    public Message(){}
    public Message(long id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return """
                ----------------------
                ID : %d
                Text : %s
                Author : %s
                ----------------------
                """.formatted(id, text, author);
    }
}
