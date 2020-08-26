package com.fedex.task.service;

import com.fedex.task.domain.TaskDetail;
import com.fedex.task.exception.TaskItemNotFoundException;
import com.fedex.task.repo.TaskRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDetail> getTaskItems() {
        log.info("Get all task items ...");
        return taskRepository.findAll();
    }

    @Override
    public TaskDetail findById(long taskId) {
        log.info("Find task item where id=" + taskId);
        Optional<TaskDetail> taskDetail = taskRepository.findById(taskId);

        if (!taskDetail.isPresent()) {
            StringBuilder errorMessage = new StringBuilder("TaskDetail not found for id: ").append(taskId);
            TaskItemNotFoundException exception = new TaskItemNotFoundException(errorMessage.toString());
            log.error(errorMessage.toString(), exception);
            throw exception;
        }

        return taskDetail.get();
    }

    @Override
    public TaskDetail createOrUpdate(TaskDetail taskDetail) {
        log.info("Create or Update task item");
        return this.taskRepository.save(taskDetail);
    }

    @Override
    public void deleteItem(long taskId) {
        log.info("Delete task item where id=" + taskId);
        this.taskRepository.deleteById(taskId);
    }
}
