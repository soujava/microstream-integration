package org.jnosql.demo.se;


import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.time.Year;
import java.util.Objects;

@Entity
public class Airplane {
    @Id
    private String id;
    @Column("title")
    private String model;
    @Column("year")
    private Year year;

    @Column
    private String manufacturer;

    Airplane(String id,
                    String model,
                    Year year, String manufacturer) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
    }


    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airplane airplane = (Airplane) o;
        return Objects.equals(id, airplane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + id + '\'' +
                ", title='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public static AirplaneBuilder id(String id) {
        return new AirplaneBuilder().id(id);
    }
}