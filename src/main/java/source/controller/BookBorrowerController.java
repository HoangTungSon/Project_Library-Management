package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import source.model.Book_Borrower;
import source.service.BookBorrowerService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BookBorrowerController {

    @Autowired
    private BookBorrowerService bookBorrowerService;

    //-------------------Retrieve All Books--------------------------------------------------------

    @RequestMapping(value = "/book-borrowers", method = RequestMethod.GET)
    public ResponseEntity<List<Book_Borrower>> listAllBook() {
        List<Book_Borrower> books = (List<Book_Borrower>) bookBorrowerService.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
