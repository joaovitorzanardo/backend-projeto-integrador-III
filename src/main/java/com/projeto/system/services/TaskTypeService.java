package com.projeto.system.services;

import com.projeto.system.dto.TaskTypeDTO;
import com.projeto.system.entities.TaskType;
import com.projeto.system.repositories.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTypeService {

    @Autowired
    TaskTypeRepository taskTypeRepository;

    public TaskType saveTaskType(TaskTypeDTO taskTypeDTO){
        TaskType taskType = TaskType.builder()
                .description(taskTypeDTO.getDescription()).build();
        return taskTypeRepository.save(taskType);
    }

    public List<TaskType> getAllTaskTypes(){
        return taskTypeRepository.findAll();
    }

}
