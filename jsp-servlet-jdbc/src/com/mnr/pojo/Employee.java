package com.mnr.pojo;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String departement;

    public Employee(int id, String firstName, String lastName, String departement) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.departement = departement;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departement='" + departement + '\'' +
                '}';
    }
}
