package com.khaledahmmedanik.main.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.khaledahmmedanik.main.entity.Admin;
import com.khaledahmmedanik.main.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

	
	 @Query("{id :?0}")                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
     Student getStudentById(String id);

	 
	 @Query(value ="{exitTime: ?0}", count=true)
     Integer getTotalBookedSeatNumber(String exitTime);

	 @Query("{id :?0}")                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
     List<Student> getStudentListById(String id);



	 @Query(value="{'id' : ?0}", delete = true)
	 void deleteStudent(String id);

	 @Query("{id :?0}") 
	 Admin getAdminInfo(String id);
	 
	 
	 @Query(value="{'isStudent' : ?0}", delete = true)
	 void deleteAllStudent(boolean b);

	 @Query("{isStudent :?0}") 
	 List<Student> getAllStudent(boolean b);
	 
	 @Query(value ="{isStudent: ?0}", count=true)
     Integer getTotalStudentsInList(boolean b);

}
