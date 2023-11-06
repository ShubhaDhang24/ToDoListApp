package shubhadhang.todolistapp.service;

import shubhadhang.todolistapp.domain.entity.Person;
import shubhadhang.todolistapp.domain.entity.Task;

import java.util.List;

public interface PersonService {

    Person  getByEmail(String email);

    List<Person> getAll();

    Person findPersonByTask(Task task);

}
