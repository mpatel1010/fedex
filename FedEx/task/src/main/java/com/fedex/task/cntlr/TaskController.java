package com.fedex.task.cntlr;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fedex.task.domain.TaskDetail;
import com.fedex.task.service.TaskService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@EnableSwagger2
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public TaskDetail getTaskItem(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping
    public List<TaskDetail> getTaskList() {
        return taskService.getTaskItems();
    }
    
    @PostMapping
    public ResponseEntity<Object> createTask(@RequestBody TaskDetail taskDetail) {
        TaskDetail newTaskIem = this.taskService.createOrUpdate(taskDetail);

        URI newTaskItemLocation =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(newTaskIem.getId())
                        .toUri();
        return ResponseEntity.created(newTaskItemLocation).build();
    }

    @PutMapping
    public ResponseEntity<String> updateTask(@RequestBody TaskDetail taskDetail) {
        TaskDetail td = this.taskService.findById(taskDetail.getId());

        td.setDesc(taskDetail.getDesc());
        td.setStatus(taskDetail.getStatus());
        td.setPlannedDate(taskDetail.getPlannedDate());
        td.setCompletedDate(taskDetail.getCompletedDate());

        this.taskService.createOrUpdate(td);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        TaskDetail foundTask = this.taskService.findById(id);
        this.taskService.deleteItem(foundTask.getId());
    }
}
