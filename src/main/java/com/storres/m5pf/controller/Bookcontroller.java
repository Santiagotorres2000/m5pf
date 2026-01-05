package com.storres.m5pf.controller;

import java.util.Collection;

import org.springframework.http.MediaType;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name= "Libros", description = "Api para la gestion de libros")
@RestController
@RequestMapping("/api/libros")
public class Bookcontroller {

 private final Bookservice bookservice;

 public Bookcontroller(Bookservice bookservice) {
    this.bookservice = bookservice;
 }
@Operation(summary = "Crear un nuevo libro", description = "crea en memoria el nuevo libro ")
@ApiResponse(responseCode = "200",  description = "libro creado correctamente")
 @PostMapping
 public Book createNewBook(@RequestBody Book book){
    return bookservice.createBook(book);
 }
@Operation(summary = "Obtener todos los libros", description = "muestra todos los libros guardados en el sistema")
 @GetMapping
 public Collection<Book> getAllBooks(Book book){
    return bookservice.getAllBooks();
 }
@Operation(summary = "Obtener libro unico", description = "muestra el libro con un identificador unico")
 @GetMapping("/{id}")
 public Book getByIdBook(@PathVariable Long id){
    return bookservice.getById(id);
 }
@Operation(summary =  "Obtiene un libro", description = "Lista los libros que contengan nombre parecidos o mismo author")
 @GetMapping(value="/buscar", produces = {MediaType.APPLICATION_JSON_VALUE})
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
