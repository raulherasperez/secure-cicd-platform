package com.raulheras.securecicdapi.repository;

import com.raulheras.securecicdapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}