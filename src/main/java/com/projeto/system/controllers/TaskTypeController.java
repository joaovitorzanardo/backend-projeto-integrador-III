package com.projeto.system.controllers;

import com.projeto.system.dto.TaskTypeDTO;
import com.projeto.system.entities.TaskType;
import com.projeto.system.services.TaskTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "task-type")
public class TaskTypeController {

    @Autowired
    TaskTypeService taskTypeService;

    @CrossOrigin
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveTaskType(@Valid @RequestBody TaskTypeDTO taskTypeDTO) {
        taskTypeService.saveTaskType(taskTypeDTO);
        return "Tipo de Tarefa Criada com Sucesso!";
    }

    @CrossOrigin
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateTaskType(@Valid @RequestBody TaskTypeDTO taskTypeDTO, @RequestParam Long taskTypeId) {
        taskTypeService.updateTaskType(taskTypeDTO, taskTypeId);
        return "Tipo de Tarefa Atualizada!";
    }

    @CrossOrigin
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteTaskType(@RequestParam Long taskTypeId) {
        taskTypeService.deleteTask(taskTypeId);
        return "Tipo de Tarefa Excluída!";
    }

    @CrossOrigin
    @GetMapping
    public List<TaskType> getAllTaskTypes() {
        return taskTypeService.getAllTaskTypes();
    }
    @CrossOrigin
    @GetMapping(params = "taskTypeId")
    @ResponseStatus(HttpStatus.OK)
    public TaskType getTaskTypeById(@RequestParam Long taskTypeId) {
        return taskTypeService.getTaskTypeById(taskTypeId);
    }

}
