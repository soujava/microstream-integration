package org.jnosql.demo.se;


import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.Objects;

@Entity
public class Book {
    @Id
    private String isbn;
    @Column("title")
    private String title;
    @Column("year")
    private int year;

    public Book(String isbn,
                String title,
                int year) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
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
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}