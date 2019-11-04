package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import source.model.Category;
import source.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //-------------------Retrieve All Category--------------------------------------------------------

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllBook() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
