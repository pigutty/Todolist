package com.pigutty.springboot.Todolist.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pigutty.springboot.Todolist.TodoData;

@Repository
public interface TodoRepository extends JpaRepository<TodoData, Long>{
	
	public Optional<TodoData> findById(Long id);
}
