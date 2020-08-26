package com.fedex.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fedex.task.domain.TaskDetail;

@Repository
public interface TaskRepository extends JpaRepository<TaskDetail, Long> {

}
