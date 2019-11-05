package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import source.model.borrower.Occupation;
import source.service.OccupationService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OccupationController {


    @Autowired
    private OccupationService occupationService;

    //-------------------Retrieve All Category--------------------------------------------------------

    @RequestMapping(value = "/occupations", method = RequestMethod.GET)
    public ResponseEntity<List<Occupation>> listAllBook() {
        List<Occupation> occupations = (List<Occupation>) occupationService.findAll();
        if (occupations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(occupations, HttpStatus.OK);
    }
}
