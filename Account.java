package com.example.saro.smartfarm;

public class Account {
    private String name;
    private String kg;

    public Account(String name,String kg){
        this.name=name;
        this.kg=kg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }
}
