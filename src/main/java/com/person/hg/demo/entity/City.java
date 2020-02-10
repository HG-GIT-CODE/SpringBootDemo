package com.person.hg.demo.entity;

public class City {

    private int id;
    private String city_name;
    private String description;

    public City() {
    }

    public City(int id, String city_name, String description) {
        this.id = id;
        this.city_name = city_name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
