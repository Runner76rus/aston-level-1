package lesson6;

import java.io.*;
import java.util.List;
import java.util.StringJoiner;

public final class MessageSerializer {

    private MessageSerializer() {}

    public static void serialize(Message message, String path) {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("ID=" + message.getId());
        joiner.add("Text=" + message.getText());
        joiner.add("Author=" + message.getAuthor());
        try(FileOutputStream out = new FileOutputStream(path)){
            out.write(joiner.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Message deserialize(String path){
        Message message;
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            List<String> data = in.lines().map(l -> l.split("=")[1]).toList();
            message = new Message();
            message.setId(Long.parseLong(data.get(0)));
            message.setText(data.get(1));
            message.setAuthor(data.get(2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}
