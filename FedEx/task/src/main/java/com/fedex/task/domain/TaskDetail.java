package com.fedex.task.domain;


import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@ApiModel(value = "TaskDetail", description = "Task Detail")
public class TaskDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @ApiModelProperty("Unique Id")
    private long id;

    @Getter @Setter
    @ApiModelProperty("desc")
    @NotNull
    @Size(min = 1, max = 200, message = "Description max length is 200 characters")
    private String desc;

    @Getter @Setter
    @ApiModelProperty(value = "status", notes = "Completed, Not Completed, Deferred etc")
    private String status;

    @Getter @Setter
    @ApiModelProperty("planned date")
    private LocalDateTime plannedDate;

    @Getter @Setter
    @ApiModelProperty("Completed Date")
    private LocalDateTime completedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDetail taskDetail = (TaskDetail) o;
        return id == taskDetail.id &&
                status == taskDetail.status &&
                Objects.equals(desc, taskDetail.desc) &&
                Objects.equals(plannedDate, taskDetail.plannedDate) &&
                Objects.equals(completedDate, taskDetail.completedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc, status, plannedDate, completedDate);
    }

    @Override
    public String toString() {
        return "TaskDetail{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", plannedDate=" + plannedDate +	
                ", completedDate=" + completedDate +
                '}';
    }
}
