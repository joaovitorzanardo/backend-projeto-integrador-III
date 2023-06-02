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

    public void saveTaskType(TaskTypeDTO taskTypeDTO){
        TaskType taskType = TaskType.builder()
                .description(taskTypeDTO.getDescription()).build();
        taskTypeRepository.save(taskType);
    }

    public void updateTaskType(TaskTypeDTO taskTypeDTO, Long taskTypeId) {
        TaskType taskType = taskTypeRepository.findByTaskTypeId(taskTypeId);
        taskType.setDescription(taskTypeDTO.getDescription());
        taskTypeRepository.save(taskType);
    }

    public void deleteTask(Long taskTypeId) {
        TaskType taskType = taskTypeRepository.findByTaskTypeId(taskTypeId);
        taskTypeRepository.delete(taskType);
    }

    public List<TaskType> getAllTaskTypes(){
        return taskTypeRepository.findAll();
    }

    public TaskType getTaskTypeById(Long taskTypeId) {
        return taskTypeRepository.findByTaskTypeId(taskTypeId);
    }

}
