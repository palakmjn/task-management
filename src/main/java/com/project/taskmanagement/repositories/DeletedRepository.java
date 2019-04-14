package com.project.taskmanagement.repositories;

import com.project.taskmanagement.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedRepository extends CrudRepository<Task,Long> {
}
