package shubhadhang.todolistapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shubhadhang.todolistapp.domain.entity.Person;

import java.util.List;

@Repository
    public interface PersonRepository extends JpaRepository<Person, Long> {

        @Query("select p from Person p where SIZE(p.tasks) = 0")
        List<Person> findIdlePeople();

        List<Person> findByEmail(String email);

    }

