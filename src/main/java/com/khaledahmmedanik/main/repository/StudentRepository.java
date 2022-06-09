package com.khaledahmmedanik.main.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.khaledahmmedanik.main.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

	
	 @Query("{id :?0}")                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
     Student getStudentById(String id);

		/*
		 * @Query(value = "{entryTime:?0}", sort= "{name:1}") List<Student>
		 * getBooksByAuthorSortByName(String entryTime);
		 */
		/*
		 * @Query("{ 'entryTime' : ?0}") List<Student>
		 * findAllStudentInEntryTimeSrotedOrder(String entryTime, Sort sort);
		 */
	 
	 @Query(value ="{exitTime: ?0}", count=true)
     Integer getTotalBookedSeatNumber(String exitTime);
	
}
