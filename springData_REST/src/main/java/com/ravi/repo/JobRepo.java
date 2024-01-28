package com.ravi.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.model.*;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

	//List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);


}
