package com.ravi.SpringBootREST.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.SpringBootREST.model.JobPost;
import com.ravi.SpringBootREST.repo.JobRepo;




@Service
public class JobService {

	@Autowired
	public JobRepo repo;
		
		//method to return all JobPosts
		public List<JobPost> getAllJobs() {
			return repo.findAll();

			
		}
		
		
		// method to add a jobPost
		public void addJob(JobPost jobPost) {
			 repo.save(jobPost);
		
		}

//method to get job by id
		public JobPost getJob(int postId) {
			
			return repo.findById(postId).orElse(new JobPost());
		}

//method to update job with job post object
		public void updateJob(JobPost jobPost) {
		repo.save(jobPost);
			
		}

//method to delete job post by id 
		public void deleteJob(int postId) {
			repo.deleteById(postId);
			
		}

		public void loadData() {
			// arrayList to store store JobPost objects
			List<JobPost> jobs = 
					new ArrayList<>(List.of(
							new JobPost()
							
					));
		
			repo.saveAll(jobs);
			
		}


		public List<JobPost> search(String keyWord) {
			return repo.findByPostProfileContainingOrPostDescContaining(keyWord,keyWord);
		}

	
}