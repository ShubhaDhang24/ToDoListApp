package shubhadhang.todolistapp.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shubhadhang.todolistapp.domain.entity.Person;
import shubhadhang.todolistapp.domain.entity.Task;

import java.time.LocalDate;
import java.util.List;

@Repository
    public interface TaskRepository extends JpaRepository<Task, Long> {

        // todo: select tasks by title

    @Query("select t from Task t where t.title = :title")
    List<Task> findByTitle(String title);


    // todo: select tasks by person id
    @Query("select t from Task t where t.title = :title and t.id=:id")
    List<Person> findByPersonId(@Param("title")String title,@Param("id")Long id);

    // todo: select tasks by status
    @Query("select t from Task t where t.done = :done")
    List<Person> findTaskByStatus(@Param("done") boolean done);

        // todo: select tasks by date between start and end
        @Query("select t from Task t where t.deadline>= :startdate and t.deadline<=:enddate")
        List<Person> findByDate(@Param("startdate") LocalDate startdate, @Param("enddate")LocalDate enddate);

        // todo: select tasks by deadline
        @Query("select t from Task t where t.deadline = :deadline")
        List<Person> findByDeadline(@Param("deadline")LocalDate deadline);

        // todo: select all un-assigned tasks

        // todo: select all un-finished tasks
        // add more as needed...

    }

