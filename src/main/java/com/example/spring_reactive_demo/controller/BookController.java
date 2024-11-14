package com.example.spring_reactive_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring_reactive_demo.model.Book;
import com.example.spring_reactive_demo.service.BookService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {
  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  // Get all books
  @GetMapping
  public Flux<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  // Get book by ID
  @GetMapping("/{id}")
  public Mono<Book> getBookById(@PathVariable Long id) {
    return bookService.getBookById(id);
  }

  // Add a new book
  @PostMapping
  public Mono<Book> addBook(@RequestBody Book book) {
    return bookService.addBook(book);
  }

  // Delete a book by ID
  @DeleteMapping("/{id}")
  public Mono<Void> deleteBook(@PathVariable Long id) {
    return bookService.deleteBook(id);
  }
}
