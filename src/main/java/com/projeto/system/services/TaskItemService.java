package com.projeto.system.services;

import com.projeto.system.constants.TaskStatus;
import com.projeto.system.dto.TaskItemDTO;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.Task;
import com.projeto.system.entities.TaskItem;
import com.projeto.system.entities.TaskType;
import com.projeto.system.repositories.ProductRepository;
import com.projeto.system.repositories.TaskItemRepository;
import com.projeto.system.repositories.TaskRepository;
import com.projeto.system.repositories.TaskTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskItemService {

    @Autowired
    TaskItemRepository taskItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TaskTypeRepository taskTypeRepository;

    @Autowired
    TaskRepository taskRepository;

    public void saveTaskItem(TaskItemDTO taskItemDTO, Long taskId) {
        Product product = productRepository.findProductByProductId(taskItemDTO.getProductId());
        TaskType taskType = taskTypeRepository.findByTaskTypeId(taskItemDTO.getTaskTypeId());
        Task task = taskRepository.findTaskByTaskId(taskId);
        TaskItem taskItem = TaskItem.builder()
                .task(task)
                .product(product)
                .taskType(taskType)
                .description(taskItemDTO.getDescription())
                .taskStatus(TaskStatus.NAO_INICIADO)
                .price(taskItemDTO.getPrice()).build();
        taskItemRepository.save(taskItem);
    }

    public void updateTaskItem(TaskItemDTO taskItemDTO, Long taskItemId) {
        TaskItem taskItem = taskItemRepository.findByTaskItemId(taskItemId);
        Product product = productRepository.findProductByProductId(taskItemDTO.getProductId());
        TaskType taskType = taskTypeRepository.findByTaskTypeId(taskItemDTO.getTaskTypeId());
        taskItem.setProduct(product);
        taskItem.setTaskType(taskType);
        taskItem.setTaskStatus(taskItemDTO.getTaskStatus());
        taskItem.setDescription(taskItemDTO.getDescription());
        taskItemRepository.save(taskItem);
    }

    public List<TaskItem> getAllTaskItemByTaskId(Long taskId) {
        Task task = taskRepository.findTaskByTaskId(taskId);
        return taskItemRepository.findAllByTask(task);
    }

}
