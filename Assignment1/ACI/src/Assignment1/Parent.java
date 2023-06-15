package Assignment1;

public class Parent {
    private String name;
    private long phone_no;
    private String email;

    public Parent() {
    }

    public Parent(String name, long phone_no, String email) {
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public String getEmail() {
        return email;
    }
}
