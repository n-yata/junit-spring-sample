package com.example.demo.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Component
public class SampleComponent {

    @Autowired
    PersonRepository personRepository;

    public int add(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public String hello() {
        return "hello world";
    }

    public String call(String msg) {
        return msg + " calling";
    }

    public void throwSample() throws Exception {
        throw new Exception("throw exception");
    }

    public String nestCall(String msg) {
        return privateCall(msg);
    }

    private String privateCall(String msg) {
        return msg + " private calling";
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }
}
