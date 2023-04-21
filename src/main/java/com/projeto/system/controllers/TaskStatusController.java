package com.projeto.system.controllers;

import com.projeto.system.dto.ProductTypeDTO;
import com.projeto.system.dto.TaskStatusDTO;
import com.projeto.system.entities.ProductType;
import com.projeto.system.entities.TaskStatus;
import com.projeto.system.services.TaskStatusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "task-status")
public class TaskStatusController {

    @Autowired
    TaskStatusService taskStatusService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TaskStatus> saveTaskStatus(@Valid @RequestBody TaskStatusDTO taskStatusDTO) {
        TaskStatus newTaskStatus = taskStatusService.saveTaskStatus(taskStatusDTO);
        return new ResponseEntity<TaskStatus>(newTaskStatus, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskStatus> getAllTaskStatus() {
        return taskStatusService.getAllTaskStatus();
    }

}
