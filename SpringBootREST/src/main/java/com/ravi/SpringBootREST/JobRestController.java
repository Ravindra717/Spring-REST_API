package com.ravi.SpringBootREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ravi.SpringBootREST.model.JobPost;
import com.ravi.SpringBootREST.service.JobService;

@RestController
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	@GetMapping("jobposts")
	public List<JobPost> getAllJobs() {
	    return service.getAllJobs();
	}
	
	@GetMapping("/jobpost/{postId}")
	public JobPost getJob(@PathVariable int postId) {
	    return service.getJob(postId);
	}
	
	@PostMapping("jobpost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
	    service.addJob(jobPost);
	    return jobPost;
	}
	
	@PutMapping("/jobpost/{postId}")
	public JobPost updateJob(@PathVariable int postId, @RequestBody JobPost jobPost) {
	    jobPost.setPostId(postId);
	    service.updateJob(jobPost);
	    return service.getJob(postId);
	}
	
	@DeleteMapping("jobpost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		service.deleteJob(postId);
		return "Deleted";
	}
	
	@GetMapping("load")
	public String loadData() {
	    service.loadData();
	    return "success";
	}
	
	@GetMapping("jobpost/keyword/{keyWord}")
	public List<JobPost> search(@PathVariable("keyWord")String keyWord){
		return service.search(keyWord);
	}
}
