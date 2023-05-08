package org.jnosql.demo.se;


import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.Objects;

@Entity
public class Airplane {
    @Id
    private String id;
    @Column("title")
    private String model;
    @Column("year")
    private int year;

    public Airplane(String id,
                    String model,
                    int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }


    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
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
}