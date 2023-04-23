package com.projeto.system.services;

import com.projeto.system.constants.TaskStatus;
import com.projeto.system.dto.TaskDTO;
import com.projeto.system.dto.TaskItemDTO;
import com.projeto.system.entities.*;
import com.projeto.system.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TeamMemberRepository teamMemberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TaskTypeRepository taskTypeRepository;


    public Task saveTask(TaskDTO taskDAO) throws ParseException {
        Date taskDeadlineDate = new SimpleDateFormat("dd/MM/yyyy").parse(taskDAO.getDeadline());
        Client client = clientRepository.findClientByClientId(taskDAO.getClientId());
        List<TaskItem> taskItems = new ArrayList<>();
        Task task = Task.builder()
                .client(client)
                .deadline(taskDeadlineDate)
                .taskStatus(TaskStatus.NAO_INICIADO)
                .build();
        if (taskDAO.getTeamMemberId() != null) {
            TeamMember teamMember = teamMemberRepository.findByTeamMemberId(taskDAO.getTeamMemberId());
            task.setTeamMember(teamMember);
        }
        for (TaskItemDTO taskItemDto : taskDAO.getTaskItems()) {
            Product product = productRepository.findProductByProductId(taskItemDto.getProductId());
            TaskType taskType = taskTypeRepository.findByTaskTypeId(taskItemDto.getTaskTypeId());
            TaskItem taskItemObject = TaskItem.builder()
                    .task(task)
                    .product(product)
                    .description(taskItemDto.getDescription())
                    .taskType(taskType)
                    .taskStatus(TaskStatus.NAO_INICIADO)
                    .price(taskItemDto.getPrice()).build();
            taskItems.add(taskItemObject);
        }
        task.setTaskItems(taskItems);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

}
