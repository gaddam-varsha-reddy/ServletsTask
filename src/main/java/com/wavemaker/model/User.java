package com.wavemaker.model;
import java.util.Objects;
public class User {
    private int id;
    private String name;
    private String gender;
    private String dob;

    public User(){

    }
    public User(int id,String name,String gender,String dob) {
        this.id = id;
        this.name=name;
        this.gender=gender;
        this.dob=dob;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id  && name.equals(user.name) && gender.equals(user.gender) && dob.equals(user.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender,dob);
    }
}
