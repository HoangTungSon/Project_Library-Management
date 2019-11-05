package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import source.model.Book;
import source.model.Book_condition;
import source.model.Category;
import source.service.BookConditionService;
import source.service.BookService;
import source.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookConditionService bookConditionService;


    //-------------------Retrieve All Books--------------------------------------------------------

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBook() {
        List<Book> books = (List<Book>) bookService.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //-------------------Retrieve Single Book--------------------------------------------------------

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        System.out.println("Fetching Book with id " + id);
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    //-------------------Create a Book--------------------------------------------------------

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody() Book book, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Book " + book.getTitle());

        Category category = categoryService.findById(book.getCategoryId());
        Book_condition book_condition = bookConditionService.findById(book.getBookConditionId());

        book.setCategory(category);
        book.setBook_condition(book_condition);

        bookService.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Book --------------------------------------------------------

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        System.out.println("Updating Book " + id);

        Book book1 = bookService.findById(id);
        if (book1 == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        book1.setTitle(book.getTitle());
        book1.setPub_date(book.getPub_date());
        book1.setPublisher(book.getPublisher());
        book1.setId(book.getId());
        book1.setCategory(categoryService.findById(book.getCategoryId()));
        book1.setBook_condition(bookConditionService.findById(book.getBookConditionId()));

        bookService.save(book1);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    //------------------- Delete a Book --------------------------------------------------------

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Book with id " + id);

        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
