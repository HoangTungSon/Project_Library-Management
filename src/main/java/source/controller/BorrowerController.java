package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import source.model.Borrower;
import source.model.Occupation;
import source.service.BorrowerService;
import source.service.OccupationService;

import java.util.List;

@RestController
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private OccupationService occupationService;

    //-------------------Retrieve All Books--------------------------------------------------------

    @RequestMapping(value = "/borrowers", method = RequestMethod.GET)
    public ResponseEntity<List<Borrower>> listAllBook() {
        List<Borrower> borrowers = (List<Borrower>) borrowerService.findAll();
        if (borrowers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(borrowers, HttpStatus.OK);
    }

    //-------------------Retrieve Single Book--------------------------------------------------------

    @RequestMapping(value = "/borrowers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Borrower> getBook(@PathVariable("id") long id) {
        System.out.println("Fetching Book with id " + id);
        Borrower borrower = borrowerService.findById(id);
        if (borrower == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(borrower, HttpStatus.OK);
    }

    //-------------------Create a Book--------------------------------------------------------

    @RequestMapping(value = "/borrowers", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody() Borrower borrower, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Book " + borrower.getName());

        Occupation occupation = occupationService.findById(borrower.getJobId());
        borrower.setOccupation(occupation);

        borrowerService.save(borrower);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/books/{id}").buildAndExpand(borrower.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Book --------------------------------------------------------

    @RequestMapping(value = "/borrowers/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Borrower> updateBook(@PathVariable("id") long id, @RequestBody Borrower borrower) {
        System.out.println("Updating Borrower " + id);

        Borrower borrower1 = borrowerService.findById(id);
        if (borrower1 == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        borrower1.setName(borrower.getName());
        borrower1.setJobId(borrower.getJobId());
        borrower1.setId(borrower.getId());
        borrower1.setNationalId(borrower.getNationalId());
        borrower1.setOccupation(occupationService.findById(borrower.getJobId()));

        borrowerService.save(borrower1);
        return new ResponseEntity<>(borrower1, HttpStatus.OK);
    }

    //------------------- Delete a Book --------------------------------------------------------

    @RequestMapping(value = "/borrowers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Borrower> deleteBook(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Borrow with id " + id);

        Borrower borrower = borrowerService.findById(id);
        if (borrower == null) {
            System.out.println("Unable to delete. Borrower with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        borrowerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
