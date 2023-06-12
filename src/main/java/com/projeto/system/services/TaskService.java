package com.projeto.system.services;

import com.projeto.system.dto.TaskDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.Task;
import com.projeto.system.entities.TaskType;
import com.projeto.system.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TaskTypeRepository taskTypeRepository;

    @Autowired
    UserRepository userRepository;


    public Task saveTask(TaskDTO taskDAO) throws ParseException {
        Date taskDeadlineDate = new SimpleDateFormat("dd/MM/yyyy").parse(taskDAO.getDeadline());
        Client client = clientRepository.findClientByClientId(taskDAO.getClientId());
        Product product = productRepository.findProductByProductId(taskDAO.getProductId());
        TaskType taskType = taskTypeRepository.findByTaskTypeId(taskDAO.getTaskTypeId());
        //User user = userRepository.findUserByUserId(taskDAO.getUserId());
        Task task = Task.builder()
                .client(client)
                .deadline(taskDeadlineDate)
                .description(taskDAO.getDescription())
                .taskType(taskType)
                .taskStatus(taskDAO.getStatus())
                .product(product)
                .price(taskDAO.getPrice())
                .build();
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findTaskByTaskId(taskId);
    }

    public void updateTask(TaskDTO taskDTO, Long taskId) throws ParseException {
        Task task = taskRepository.findTaskByTaskId(taskId);
        Date taskDeadlineDate = new SimpleDateFormat("dd/MM/yyyy").parse(taskDTO.getDeadline());
        Client client = clientRepository.findClientByClientId(taskDTO.getClientId());
        Product product = productRepository.findProductByProductId(taskDTO.getProductId());
        TaskType taskType = taskTypeRepository.findByTaskTypeId(taskDTO.getTaskTypeId());
        task.setTaskStatus(taskDTO.getStatus());
        task.setClient(client);
        task.setDeadline(taskDeadlineDate);
        task.setPrice(taskDTO.getPrice());
        task.setTaskType(taskType);
        task.setDescription(taskDTO.getDescription());
        task.setProduct(product);
        taskRepository.save(task);
    }

    public Task getTaskByClientCpf(String clientCpf) {
        Client client = clientRepository.findClientByCpf(clientCpf);
        return taskRepository.findTaskByClient(client);
    }

}
