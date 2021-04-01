package entity;

import java.time.LocalDate;

public class Buyer extends User{

    private String Name;
    private LocalDate RegistrationDate;

    public Buyer(int id, String name, String password, LocalDate registrationDate) {
        super(id, name, password);
        Name = name;
        RegistrationDate = registrationDate;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        Name = name;
    }

    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        RegistrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "Name='" + Name + '\'' +
                ", RegistrationDate=" + RegistrationDate +
                '}';
    }

    public Buyer(int id, String name, String password) {
        super(id, name, password);
    }
}
