package shubhadhang.todolistapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import shubhadhang.todolistapp.repository.TaskRepository;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private  final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {

        // return taskRepository.findAll();
        return null;
    }

    @Override
    public List<Task> getByTitle(String title) {
        return taskRepository.findByTitle(title);

    }

    @Override
    public boolean getByDoneStatus(Boolean done) {
        return false;
    }
}