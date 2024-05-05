package lesson6;

public class TestSerialization {

    public static void main(String[] args) {
        Message message = new Message(777L,"test","tester");
        String path = "/home/runner76rus/projects/aston-cousre-level-1/src/main/resources/message.txt";
        MessageSerializer.serialize(message,path);
        System.out.println(MessageSerializer.deserialize(path));

    }
}
