package com.projeto.system.repositories;

import com.projeto.system.entities.Client;
import com.projeto.system.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public Task findTaskByTaskId(Long taskId);

    public Task findTaskByClient(Client clientId);

}
