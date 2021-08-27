package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    String sql = "SELECT COUNT(*) FROM person WHERE name = :val";

    @Query(value = sql, nativeQuery = true)
    public int findCount(
            @Param("val") String val);
}
