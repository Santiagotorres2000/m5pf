package com.storres.m5pf.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.storres.m5pf.model.Book;
import com.storres.m5pf.model.EstadoLibro;

@Service
//JAVADOC
/**
 * esta clase implementa los metodos para el uso del BookController
 * tenemos metodos de crud 
 */
public class BookServiceimpl implements Bookservice {

    private Map<Long, Book> books;
    private AtomicLong consecutive;

    public BookServiceimpl() {
        this.books = new HashMap<>();
        this.consecutive = new AtomicLong(1);

    }

    @Override
    public Book createBook(Book book) {
        Long id = consecutive.getAndIncrement();
        book.setId(id);
        books.put(id, book);
        return book;
        // books.put(book.getId(), book);
        // return book;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    @Override
    public Book getById(Long id) {
        validateId(id);
        Book book = books.get(id);

        return book;
    }
/**
 * actualiza el objeto Book book 
 * 
 * @param id identificacion una genera por automaticamente por el 
 * @param  objecto de Book tipo book
 * @throws illegalArgumentsException en caso de que no se pueda encontrar el id del libro
 */
    @Override
    public Book upgradeBook(Long id, Book book) {
        var existing = books.get(id);

        if (existing == null) {
            throw new IllegalArgumentException("No se puede actualizar el usuario. id no encontrado {}" + id);
        }
        existing.setAuthor(book.getAuthor());
        existing.setEstadoLibro(book.getEstadoLibro());
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
        return existing;
    }

    @Override
    public void deleteBook(Long id) {
        validateId(id);
        books.remove(id);

    }

    @Override
    public Collection<Book> bookContainsAoT(String name) {
        return books.values()
                .stream().filter(b -> b.getTitle() != null &&
                        b.getTitle().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    @Override
    public Book oweBook(Long id) {
        validateId(id);
        Book book = books.get(id);
        if (book.getEstadoLibro() == EstadoLibro.PRESTADO) {
            throw new IllegalStateException("El libro ya se encuentra prestado");
           

        }
        book.setEstadoLibro(EstadoLibro.PRESTADO);
        return book;
    }

    private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El Id está vacio");
        }
        if (id < 0) {
            throw new IllegalArgumentException("El Id no puede ser negativo");
        }
    }

}
