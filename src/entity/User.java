package entity;

public class User extends Person {

    private String Name;
    private String Password;

    public User(int id, String name, String password) {
        super(id);
        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
