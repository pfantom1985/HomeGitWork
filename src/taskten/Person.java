package taskten;

import java.util.List;

public class Person {

    private int id;
    private String name;
    private boolean permanent;
    private Address address;
    private int[] phoneNumber;
    private String role;
    private List<String> cities;

    public Person() {
    }

    public Person(int id, String name, boolean permanent, int[] phoneNumber, String role, List<String> cities) {
        this.id = id;
        this.name = name;
        this.permanent = permanent;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.cities = cities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int[] getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}