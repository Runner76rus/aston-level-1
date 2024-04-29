package lesson1.task2;

public class TestProperty {
    public static void main(String[] args) {
        System.out.println(PropertiesUtil.get("db.username"));
        System.out.println(PropertiesUtil.get("db.password"));
        System.out.println(PropertiesUtil.get("db.url"));
    }
}
