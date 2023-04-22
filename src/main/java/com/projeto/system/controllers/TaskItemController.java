package com.projeto.system.controllers;

import com.projeto.system.dto.TaskItemDTO;
import com.projeto.system.services.TaskItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "task-item")
public class TaskItemController {

    @Autowired
    TaskItemService taskItemService;

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String updateTaskItem(@Valid @RequestBody TaskItemDTO taskItemDTO, @RequestParam Long taskItemId) {
        taskItemService.updateTaskItem(taskItemDTO, taskItemId);
        return "Item da Tarefa Atualizado!";
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteTaskItem(@RequestParam Long taskItemId) {
        taskItemService.deleteTaskItem(taskItemId);
        return "Item da Tarefa Excluído!";
    }

}
