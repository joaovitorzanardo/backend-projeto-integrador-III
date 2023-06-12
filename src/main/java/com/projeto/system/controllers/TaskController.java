package com.projeto.system.controllers;

import com.projeto.system.dto.ProductDTO;
import com.projeto.system.dto.TaskDTO;
import com.projeto.system.entities.Product;
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

    @CrossOrigin
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveTask(@Valid @RequestBody TaskDTO taskDTO) throws ParseException {
        Task newTask = taskService.saveTask(taskDTO);
        return "Tarefa Criada com Sucesso!";
    }

    @CrossOrigin
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateTask(@Valid @RequestBody TaskDTO taskDTO, @RequestParam Long taskId) throws ParseException {
        taskService.updateTask(taskDTO, taskId);
        return "Tarefa Atualizada!";
    }

    @CrossOrigin
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @CrossOrigin
    @GetMapping(params = "taskId")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskById(@RequestParam Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @CrossOrigin
    @GetMapping(params = "clientCpf")
    @ResponseStatus(HttpStatus.OK)
    public Task getTaskByClientCpf(@RequestParam String clientCpf) {
        return taskService.getTaskByClientCpf(clientCpf);
    }

}
