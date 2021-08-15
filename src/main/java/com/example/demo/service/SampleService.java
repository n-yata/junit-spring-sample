package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.component.SampleComponent;
import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    SampleComponent component;

    @Getter
    private int addResult;
    @Getter
    private int minusResult;
    @Getter
    private String helloResult;
    @Getter
    private String callResult;

    /**
     * データの一覧を返す
     * @return
     */
    public List<Person> findAll() {

        List<Person> persons = component.findAll();

        return persons;
    }

    /**
     * 新規登録する
     * @param person
     * @return
     */
    public void save(Person person) {

        component.save(person);

        log.info("Add: " + person);

    }

}