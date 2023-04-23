package com.projeto.system.repositories;

import com.projeto.system.entities.Product;
import com.projeto.system.entities.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {

    public TaskItem findByTaskItemId(Long taskItemId);

    public TaskItem findByProduct(Product product);

}
