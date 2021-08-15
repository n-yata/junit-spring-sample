package com.example.demo.component;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.repository.PersonRepository;

@SpringBootTest
class SampleComponentTest {

    @MockBean
    PersonRepository personRepository;

    @Autowired
    @InjectMocks
    SampleComponent target;

    @Nested
    class addメソッド {

        @Test
        void addに1と2で3() {
            int expect = 3;

            assertEquals(expect, target.add(1, 2));
        }
    }

}
