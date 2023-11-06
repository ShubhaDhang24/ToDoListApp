package shubhadhang.todolistapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shubhadhang.todolistapp.domain.entity.Person;
import shubhadhang.todolistapp.domain.entity.Task;
import shubhadhang.todolistapp.repository.PersonRepository;
import shubhadhang.todolistapp.repository.TaskRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private  final  PersonRepository personRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepo, TaskRepository taskRepository) {
        this.personRepository = personRepo;
        this.taskRepository = taskRepository;
    }

    @Override
    public Person getByEmail(String email) {

        return (Person) personRepository.findByEmail(email);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findPersonByTask(Task task) {
        return  Task.builder().build().getPerson();
    }
}
