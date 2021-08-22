package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entity.Person;

@DataJpaTest
@ActiveProfiles("test")
class PersonRepositoryTest {

    @Autowired
    TestEntityManager manager;

    @Autowired
    PersonRepository target;

    @BeforeEach
    void beforeEach() {
        manager.persist(new Person("テスト太郎", 18));

    }

    @Test
    void test() {

        List<Person> persons = target.findAll();

        assertEquals(1, persons.size());

        System.out.println(persons.get(0).toString());
    }

    @Test
    void test2() {
        manager.persist(new Person("テスト次郎", 20));

        List<Person> persons = target.findAll();

        assertEquals(2, persons.size());
    }

    @Test
    void test3() {
        target.save(new Person("テスト三郎", 15));

        List<Person> persons = target.findAll();

        assertEquals(2, persons.size());

        System.out.println(persons.get(1).toString());

    }

}
