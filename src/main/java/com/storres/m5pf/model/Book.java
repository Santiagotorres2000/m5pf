package com.storres.m5pf.model;

import java.time.LocalDate;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate datev;
    private EstadoLibro estadoLibro;

    public Book() {
    }

    public Book(String author, LocalDate datev, EstadoLibro estadoLibro, Long id, String isbn, String title) {
        this.author = author;
        this.datev = datev;
        this.estadoLibro = estadoLibro;
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public EstadoLibro getEstadoLibro() {
        return estadoLibro;
    }

    public void setEstadoLibro(EstadoLibro estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    public LocalDate getDatev() {
        return datev;
    }

    public void setDatev(LocalDate datev) {
        this.datev = datev;
    }

}
