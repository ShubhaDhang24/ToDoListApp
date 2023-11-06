package shubhadhang.todolistapp.service;

import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    List<Task> getByTitle(String title);

    boolean getByDoneStatus(Boolean done);
}
