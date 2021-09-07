package com.elotech.peoplecontacts.Controller;

import com.elotech.peoplecontacts.Exception.NotFoundException;
import com.elotech.peoplecontacts.model.People;
import com.elotech.peoplecontacts.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping
    public String getAllPeople(){
        //return peopleRepository.findAll()List<People>;
        return "Teste"
        }

    @GetMapping("/{id}")
    public ResponseEntity<People> getOnePeople(@PathVariable(value = "id") Integer id) throws NotFoundException {
       People people = peopleRepository.findById(id)
               .orElseThrow(()-> new NotFoundException("Pessoa não encontrada com o id ::" + id));
        return ResponseEntity.ok(people);
    }

    @PostMapping
    public People createPeople( @RequestBody People people){return peopleRepository.save(people);}

    @PutMapping
    public ResponseEntity<People> updatePeople (@RequestBody People people) throws NotFoundException {
        peopleRepository.findById(people.getId())
                .orElseThrow(()-> new NotFoundException("Pessoa não encontrada com o id ::" + people.getId()));
        People newPeople = peopleRepository.save(people);
        return ResponseEntity.ok(newPeople);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoom (@PathVariable(value = "id") Integer id) throws NotFoundException {
        peopleRepository.findById(id).orElseThrow(()-> new NotFoundException("Pessoa não encontrada com o id ::"+id));
        peopleRepository.deleteById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deletado", Boolean.TRUE);
        return response;
    }

}
