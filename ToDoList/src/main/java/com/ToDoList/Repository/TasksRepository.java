package com.ToDoList.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ToDoList.Entities.Tasks;

public interface TasksRepository extends JpaRepository<Tasks,Integer> {
	
	@Query("from Tasks as T where T.user.SerialNo= :SerialNo")
	public List<Tasks> FindTasksByUsername(@Param("SerialNo") int TaskNo);

}
