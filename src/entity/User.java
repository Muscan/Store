package entity;

public class User extends Person {

    private String name;
    private String password;

    public User(int id, String name, String password) {
        super(id);
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + name + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
