package com.example.demo.usercv.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.usercv.bean.PersonalDetails;

@Repository
public interface UserCVRepo extends CrudRepository<PersonalDetails, Integer>{
	
		@Query(value="select *from personal_details where email=?1", nativeQuery = true)
		public PersonalDetails findByEmail(String email);
}
