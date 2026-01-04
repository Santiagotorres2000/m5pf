package com.storres.m5pf.service;

import java.util.Collection;

import com.storres.m5pf.model.Book;

public interface Bookservice {
    
    public Book createBook(Book book);

    public Collection<Book> getAllBooks();

    public Book getById(Long id);

    public Book upgradeBook(Long id,Book book);

    public void deleteBook(Long id);

    public Collection<Book> bookContainsAoT(String isbn);

    public Book oweBook(Long id);
    
}
