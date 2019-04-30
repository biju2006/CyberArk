package com.example.rest.springrest;

import com.example.rest.springrest.beans.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest")
public class MyController {

    @GetMapping("sum/{num1}/{num2}")
    public int sum(@PathVariable("num1") int x, @PathVariable("num2") int y){
        return x+y;
    }

    @PostMapping("greet")
    public String greet(@RequestParam(value="user", defaultValue = "NoName") String name){
        return "Hello "+name;
    }

    @GetMapping("all")
    public List<Person> getAll(){
        return List.of(Person.builder().name("aaa").age(10).build(),
                Person.builder().name("bbb").age(20).build(),
                Person.builder().name("ccc").age(30).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person /*PersonResource*/> update(@PathVariable("id") int id,
                                                            @RequestBody Person p /*PersonDTO*/){
        // Person p = repository.findOne(id);
        if (id==1/*p == null*/) {
            return ResponseEntity.notFound().build();
        }
        p.setName(p.getName()+" handled by server");
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Person> add(@RequestBody Person p){
        if(p.getAge()<0||p.getAge()>120){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(p);
    }

}
