package com.khaledahmmedanik.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.khaledahmmedanik.main.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

	
	 @Query("{id :?0}")                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
     Student getStudentById(String id);

	
}
