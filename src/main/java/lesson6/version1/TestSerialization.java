package lesson6.version1;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestSerialization implements Serializable {

    public static void main(String[] args) {
        Message message = new Message(777L,"test","tester",new String[]{"hello","world"});
        Path path = Paths.get("/home/runner76rus/projects/aston-cousre-level-1/src/main/resources/message.txt");
        message.writeObject(path);
        Message newMsg = new Message();
        System.out.println(newMsg.readObject(path));

    }



}
