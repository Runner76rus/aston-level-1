package homework1.task1;

public class TestUser {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(-24);
        user.setName("");
        user.setEmail("vellprolol@gmail.com");
        System.out.println(user);

        System.out.println(user.getClass().getClassLoader());
        System.out.println(user.getClass().getSimpleName());
    }
}
