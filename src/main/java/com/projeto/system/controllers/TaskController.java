package com.projeto.system.controllers;

import com.projeto.system.dto.TaskDTO;
import com.projeto.system.entities.Task;
import com.projeto.system.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveTask(@Valid @RequestBody TaskDTO taskDTO) throws ParseException {
        Task newTask = taskService.saveTask(taskDTO);
        return "Tarefa Criada com Sucesso!";
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

}
