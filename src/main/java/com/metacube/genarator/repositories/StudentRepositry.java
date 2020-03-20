package com.metacube.genarator.repositories;

import com.metacube.genarator.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentRepositry")
public interface StudentRepositry extends JpaRepository<StudentEntity, Long>{

}
