package lesson6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Message implements MySerializable<Message>{

    private long id;
    private String text;
    private String author;
    private String[] tags;

    public Message(){}
    public Message(long id, String text, String author, String[] tags) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.tags = tags;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
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
        StringBuilder builder = new StringBuilder();
        builder.append("""
                ----------------------
                ID : %d
                Text : %s
                Author : %s
                """.formatted(id, text, author));
        for (String tag : tags) {
            builder.append("#").append(tag).append(System.lineSeparator());
        }
        builder.append("----------------------");
        return builder.toString().trim();
    }

    @Override
    public Path writeObject(Path path) {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("ID=" + id);
        joiner.add("Text=" + text);
        joiner.add("Author=" + author);
        for (String tag : tags) {
            joiner.add("tag=" + tag);
        }
        try{
            Files.writeString(path, joiner.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    @Override
    public Message readObject(Path path) {
        try(Stream<String> lines = Files.lines(path)){
            List<String> data = lines.map(l -> l.split("=")[1]).toList();
            this.id = Long.parseLong(data.get(0));
            this.text = data.get(1);
            this.author = data.get(2);
            this.tags = new String[data.size() - 3];
            for (int i = 3; i < data.size(); i++) {
                this.tags[i - 3] = data.get(i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
