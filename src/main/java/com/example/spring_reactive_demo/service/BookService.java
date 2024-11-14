package com.example.spring_reactive_demo.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.spring_reactive_demo.model.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
  private final Map<Long, Book> bookRepo = new HashMap<>();

  public Flux<Book> getAllBooks() {
    return Flux.fromIterable(bookRepo.values());
  }

  public Mono<Book> getBookById(Long id) {
    return Mono.justOrEmpty(bookRepo.get(id));
  }

  public Mono<Book> addBook(Book book) {
    bookRepo.put(book.getId(), book);
    return Mono.just(book);
  }

  public Mono<Void> deleteBook(Long id) {
    bookRepo.remove(id);
    return Mono.empty();
  }
}
