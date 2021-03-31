package entity;

import java.time.LocalDate;

public class Worker extends Person{


    private String name;
    private String phoneNumber;
    private int salary;
    private String email;
    private LocalDate startDate;

    public Worker(int id, String name, String phoneNumber, int salary, String email, LocalDate startDate) {
        super(id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.email = email;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
