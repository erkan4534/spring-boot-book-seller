package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.Book;
import com.sha.springbootbookseller.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")//pre-path
public class BookController {

    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping //api/book
    public ResponseEntity<?> saveBook(@RequestBody Book book){
              return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<?>deleteBook(@PathVariable Long bookId){
         bookService.deleteBook(bookId);
         return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping //api/book
    public ResponseEntity<?> getAllBooks(){
       return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
    }

}
