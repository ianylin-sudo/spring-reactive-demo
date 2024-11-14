package com.example.spring_reactive_demo.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  private Long id;
  private String titles;
  private String author;
  private LocalDate publishedDate;
  private String genre;
}
