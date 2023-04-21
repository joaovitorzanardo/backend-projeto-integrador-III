package com.projeto.system.services;

import com.projeto.system.constants.TaskStatus;
import com.projeto.system.dto.TaskDTO;
import com.projeto.system.entities.Client;
import com.projeto.system.entities.Task;
import com.projeto.system.entities.TeamMember;
import com.projeto.system.repositories.ClientRepository;
import com.projeto.system.repositories.TaskRepository;
import com.projeto.system.repositories.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TeamMemberRepository teamMemberRepository;


    public Task saveTask(TaskDTO taskDAO) {
        Client client = clientRepository.findClientByClientId(taskDAO.getClientId());
        Task task = Task.builder()
                .client(client)
                .deadline(taskDAO.getDeadline())
                .taskStatus(TaskStatus.NAO_INICIADO)
                .totalPrice(0.0)
                .build();
        if (taskDAO.getTeamMemberId() != null) {
            TeamMember teamMember = teamMemberRepository.findByTeamMemberId(taskDAO.getTeamMemberId());
            task.setTeamMember(teamMember);
        }
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

}
