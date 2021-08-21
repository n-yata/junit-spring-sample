package com.example.demo.component;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@SpringBootTest
@SpringJUnitConfig
class SampleComponentTest {

    @MockBean
    PersonRepository personRepository;

    @Autowired
    @InjectMocks
    SampleComponent target;

    @Configuration
    static class innerConfig {

        @Bean
        SampleComponent sampleComponent() {
            return new SampleComponent();
        }

    }

    @Nested
    class add {

        @Test
        void addに1と2で3() {
            int expected = 3;

            assertEquals(expected, target.add(1, 2));
        }

        @Test
        void addに3と2で5() {
            int expected = 5;

            assertEquals(expected, target.add(3, 2));
        }
    }

    @Nested
    class minus {

        @Test
        void minusに3と2で1() {
            int expected = 1;

            assertEquals(expected, target.minus(3, 2));
        }

        @Test
        void minusに5と3で2() {
            int expected = 2;

            assertEquals(expected, target.minus(5, 3));
        }
    }

    @Nested
    class hello {

        @Test
        void helloでhelloWorld() {
            String expected = "hello world";

            assertEquals(expected, target.hello());
        }
    }

    @Nested
    class call {
        String call = " calling";

        @Test
        void callにyoでyocalling() {
            String expected = "yo" + call;

            assertEquals(expected, target.call("yo"));
        }

        @Test
        void callにheyでheycalling() {
            String expected = "hey" + call;

            assertEquals(expected, target.call("hey"));
        }
    }

    @Nested
    class throwSample {

        @Test
        void throwSampleでthrowException() {
            String expected = "throw exception";

            Exception thrown = assertThrows(Exception.class, () -> target.throwSample());

            assertEquals(expected, thrown.getMessage());
        }
    }

    @Nested
    class nestCall {
        String privateCall = " private calling";

        @Test
        void nestCallにyoでyoprivatecalling() {
            String expected = "yo" + privateCall;

            assertEquals(expected, target.nestCall("yo"));
        }

        @Test
        void nestCallにheyでheyprivatecalling() {
            String expected = "hey" + privateCall;

            assertEquals(expected, target.nestCall("hey"));
        }
    }

    @Nested
    class findAll {

        @Test
        void findAllでlistを返す() {
            Person person1 = new Person();
            person1.setId(1);
            person1.setName("テスト太郎");
            person1.setAge(18);

            Person person2 = new Person();
            person2.setId(2);
            person2.setName("テスト次郎");
            person2.setAge(19);

            List<Person> persons = Arrays.asList(person1, person2);

            when(personRepository.findAll()).thenReturn(persons);

            List<Person> actualList = target.findAll();

            assertSame(person1, actualList.get(0));
            assertSame(person2, actualList.get(1));
        }
    }

    @Nested
    class save {

        @Test
        void saveでdonothing() {
            target.save(new Person());

            // do nothing
        }
    }
}
