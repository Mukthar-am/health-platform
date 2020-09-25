package com.platform.core.metadata;

public class User {
    private int Id;
    private String Name = null;
    private int Age;
    private String Gender;

    public User() { }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("(id: " + Id + ", ");
        userInfo.append("name: " + Name + ", ");
        userInfo.append("age: " + Age + ", ");
        userInfo.append("gender: " + Gender + ")");
        return userInfo.toString();
    }
}
