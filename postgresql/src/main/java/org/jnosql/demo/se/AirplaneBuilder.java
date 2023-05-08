package org.jnosql.demo.se;

import java.time.Year;

public class AirplaneBuilder {
    private String id;
    private String model;
    private Year year;
    private String manufacturer;

    public AirplaneBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AirplaneBuilder model(String model) {
        this.model = model;
        return this;
    }

    public AirplaneBuilder year(Year year) {
        this.year = year;
        return this;
    }

    public AirplaneBuilder year(int year) {
        this.year = Year.of(year);
        return this;
    }

    public Airplane manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return build();
    }

    public Airplane build() {
        return new Airplane(id, model, year, manufacturer);
    }
}