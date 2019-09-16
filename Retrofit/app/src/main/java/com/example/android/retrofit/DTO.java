package com.example.android.retrofit;

public class DTO {

    String name;
    String age;
    String language;

    public DTO(String name, String age, String language) {
        this.name = name;
        this.age = age;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
