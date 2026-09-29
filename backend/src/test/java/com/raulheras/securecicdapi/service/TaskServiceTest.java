package com.raulheras.securecicdapi.service;

import com.raulheras.securecicdapi.model.Task;
import com.raulheras.securecicdapi.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void shouldReturnAllTasks() {
        Task task = new Task("Test task", "Test description");

        when(taskRepository.findAll())
                .thenReturn(List.of(task));

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(1, tasks.size());
        assertEquals("Test task", tasks.get(0).getTitle());

        verify(taskRepository).findAll();
    }

    @Test
    void shouldReturnTaskById() {
        Task task = new Task("Test task", "Test description");

        when(taskRepository.findById(1L))
                .thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getTaskById(1L);

        assertTrue(result.isPresent());
        assertEquals("Test task", result.get().getTitle());
    }

    @Test
    void shouldCreateTask() {
        Task task = new Task("New task", "Description");

        when(taskRepository.save(task))
                .thenReturn(task);

        Task result = taskService.createTask(task);

        assertEquals("New task", result.getTitle());
        verify(taskRepository).save(task);
    }

    @Test
    void shouldDeleteTask() {
        taskService.deleteTask(1L);

        verify(taskRepository).deleteById(1L);
    }
}