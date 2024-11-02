package com.atyas.jobmicroservice.job;

import com.atyas.jobmicroservice.job.dto.JobWithCompanyDTO;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDTO> findAll();

    void createJob(Job job);

    JobWithCompanyDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
