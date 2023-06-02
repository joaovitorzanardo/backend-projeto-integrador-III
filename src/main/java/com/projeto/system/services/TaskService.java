package com.projeto.system.services;

import com.projeto.system.dto.TaskDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.Product;
import com.projeto.system.entities.Task;
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
        //User user = userRepository.findUserByUserId(taskDAO.getUserId());
        Task task = Task.builder()
                .client(client)
                .deadline(taskDeadlineDate)
                .description(taskDAO.getDescription())
                .taskStatus(taskDAO.getStatus())
                .product(product)
                .price(taskDAO.getPrice())
                .build();
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

}
