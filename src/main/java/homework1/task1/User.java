package homework1.task1;

public class User {

    private int age;
    private String name;
    private String email;

    @Override
    public String toString() {
        return String.format("""
                ----------------------
                Age : %d
                Name : %s
                Email : %s
                ----------------------
                """, age, name, email);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "Anonymous";
        } else {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null ||
            email.isEmpty() ||
            !email.matches("\\w+@\\w+.\\w+")) {
            throw new IllegalArgumentException("Email is not valid");
        } else {
            this.email = email;
        }
    }
}
