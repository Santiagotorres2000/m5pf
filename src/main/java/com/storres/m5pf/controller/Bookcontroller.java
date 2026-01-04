package com.storres.m5pf.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.storres.m5pf.model.Book;
import com.storres.m5pf.service.Bookservice;

@RestController
@RequestMapping("/api/libros")
public class Bookcontroller {

 private final Bookservice bookservice;

 public Bookcontroller(Bookservice bookservice) {
    this.bookservice = bookservice;
 }

 @PostMapping
 public Book createNewBook(@RequestBody Book book){
    return bookservice.createBook(book);
 }

 @GetMapping
 public Collection<Book> getAllBooks(Book book){
    return bookservice.getAllBooks();
 }

 @GetMapping("/{id}")
 public Book getByIdBook(@PathVariable Long id){
    return bookservice.getById(id);
 }

 @GetMapping("/buscar")
 public Collection<Book> getBooksContains(@RequestParam ("nombre") String isbn){
    return bookservice.bookContainsAoT(isbn);
 }

 @PostMapping("/{id}/prestar")
 public Book oweBooks(@PathVariable Long id){
    return bookservice.oweBook(id);
 }

 @PutMapping("/{id}")
 public Book actBook(@PathVariable Long id, @RequestBody Book book){
    return bookservice.upgradeBook(id ,book);
 }

 @DeleteMapping("/{id}")
 public void deleteBook(@PathVariable Long id){
    bookservice.deleteBook(id);
 }
 

    
}
