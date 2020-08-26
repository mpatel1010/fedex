package com.fedex.task.service;


import java.util.List;

import com.fedex.task.domain.TaskDetail;

public interface TaskService {

    List<TaskDetail> getTaskItems();
    TaskDetail findById(long taskId);
    TaskDetail createOrUpdate(TaskDetail taskDetail);
    void deleteItem(long taskId);
}