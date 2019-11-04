package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import source.model.Book;
import source.model.Book_condition;
import source.service.BookConditionService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BookConditionController {

    @Autowired
    private BookConditionService bookConditionService;

    //-------------------Retrieve All Books--------------------------------------------------------

    @RequestMapping(value = "/bookCondition", method = RequestMethod.GET)
    public ResponseEntity<List<Book_condition>> listAllBook() {
        List<Book_condition> book_conditions = (List<Book_condition>) bookConditionService.findAll();
        if (book_conditions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(book_conditions, HttpStatus.OK);
    }
}
