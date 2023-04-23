package com.projeto.system.controllers;

import com.projeto.system.dto.TaskItemDTO;
import com.projeto.system.services.TaskItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "task-item")
public class TaskItemController {

    @Autowired
    TaskItemService taskItemService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public String saveTaskItem(@Valid @RequestBody TaskItemDTO taskItemDTO) {
        taskItemService.saveTaskItem(taskItemDTO);
        return "Item Cadastrado com Sucesso!";
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public String updateTaskItem(@Valid @RequestBody TaskItemDTO taskItemDTO, @RequestParam Long taskItemId) {
        taskItemService.updateTaskItem(taskItemDTO, taskItemId);
        return "Item Atualizado!";
    }

}
