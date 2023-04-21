package com.projeto.system.services;

import com.projeto.system.dto.TaskStatusDTO;
import com.projeto.system.entities.TaskStatus;
import com.projeto.system.repositories.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusService {

    @Autowired
    TaskStatusRepository taskStatusRepository;

    public TaskStatus saveTaskStatus(TaskStatusDTO taskStatusDTO){
        TaskStatus taskStatus = TaskStatus.builder()
                .description(taskStatusDTO.getDescription()).build();
        return taskStatusRepository.save(taskStatus);
    }

    public List<TaskStatus> getAllTaskStatus(){
        return taskStatusRepository.findAll();
    }

}
