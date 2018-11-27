package models;

import java.util.Objects;

public class BookCharacter {
    private String fname, sname, nickname, gender, description;
    private int age, height;//TODO Bday
    private double weight;

    public BookCharacter(String fname, String sname, String nickname, String gender, String description, int age, int height, double weight) {
        this.fname = !fname.isEmpty() ? fname : "NOT GIVEN";
        this.sname = !sname.isEmpty() ? sname : ""; //can be empty
        this.nickname = !nickname.isEmpty() ? nickname : ""; //can be empty
        this.gender = !gender.isEmpty() ? gender : "UNKNOWN"; //if none provided, will be unknown
        this.description = !description.isEmpty() ? description : "This bio is empty..."; //bio defaults
        this.age = age>=0 ? age : 0;
        this.height = height>=0 ? height : 0;
        this.weight = weight>=0 ? weight : 0;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        if(!fname.isEmpty()) this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = !sname.isEmpty() ? sname : "";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = !nickname.isEmpty() ? nickname : "";
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = !gender.isEmpty() ? gender : "UNKNOWN";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = !description.isEmpty() ? description : "This bio is empty...";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0) this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height>=0) this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight>=0) this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFname(), getSname(), getNickname(), getGender(), getDescription(), getAge(), getHeight(), getWeight());
    }
}
