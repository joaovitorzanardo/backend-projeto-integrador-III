package com.projeto.system.controllers;

import com.projeto.system.dto.TaskTypeDTO;
import com.projeto.system.entities.TaskType;
import com.projeto.system.services.TaskTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "task-type")
public class TaskTypeController {

    @Autowired
    TaskTypeService taskTypeService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TaskType> saveTaskType(@Valid @RequestBody TaskTypeDTO taskTypeDTO) {
        TaskType newTaskType = taskTypeService.saveTaskType(taskTypeDTO);
        return new ResponseEntity<>(newTaskType, HttpStatus.CREATED);
    }

    @GetMapping
    public List<TaskType> getAllTaskTypes() {
        return taskTypeService.getAllTaskTypes();
    }

}
