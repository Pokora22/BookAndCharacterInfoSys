package models;

import java.util.Objects;

public class BookCharacter {
    private String fname, sname, nickname, gender, description;
    private int age, height;//TODO Bday
    private double weight;

    public BookCharacter(String fname, String sname, String nickname, String gender, String description, int age, int height, double weight) {
        this.fname = fname;
        this.sname = sname;
        this.nickname = nickname;
        this.gender = gender;
        this.description = description;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFname(), getSname(), getNickname(), getGender(), getDescription(), getAge(), getHeight(), getWeight());
    }
}
