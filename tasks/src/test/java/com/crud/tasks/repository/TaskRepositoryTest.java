package com.crud.tasks.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;


@SpringBootTest
class TaskRepositoryTest {
    
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testTaskRepositoryFindById() {
        //Given
        Task task = new Task();

        //When
        taskRepository.save(task);

        //Then
        Long id = task.getId();
        Optional<Task> readTask = taskRepository.findById(id);
        assertTrue(readTask.isPresent());

        //CleanUp
        taskRepository.deleteById(id);
    }

    @Test
    public void testTaskRepositoryFindAll() {
        //Given
        Task task1 = new Task();
        Task task2 = new Task();

        //When
        taskRepository.save(task1);
        taskRepository.save(task2);

        //Then
        Long id1 = task1.getId();
        Long id2 = task2.getId();
        List<Task> listTasks = taskRepository.findAll();
        assertEquals(2, listTasks.size());

        //CleanUp
        taskRepository.deleteById(id1);
        taskRepository.deleteById(id2);
    }

    @Test
    public void testTaskRepositoryDeleteById() {
        //Given
        Task task1 = new Task();
        Task task2 = new Task();

        //When
        taskRepository.save(task1);
        taskRepository.save(task2);

        //Then
        Long id1 = task1.getId();
        Long id2 = task2.getId();
        taskRepository.deleteById(id2);
        assertEquals(1, taskRepository.findAll().size());

        //CleanUp
        taskRepository.deleteById(id1);
    }
}
