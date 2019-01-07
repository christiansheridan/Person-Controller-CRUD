package io.zipcoder.crudapp;

import io.zipcoder.crudapp.Person;
import io.zipcoder.crudapp.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path = "/person")
    @ResponseBody
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping(path = "/person/{id}")
    @ResponseBody
    public ResponseEntity<Person> getPerson(@PathVariable int id){
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping(path = "/person")
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<> ((List<Person>) personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/person/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable int id){
        id = p.getId();
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
    }

    @DeleteMapping(path = "/person/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable int id){
        personRepository.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
