package com.atyas.jobmicroservice.job.mapper;

import com.atyas.jobmicroservice.job.Job;
import com.atyas.jobmicroservice.job.dto.JobWithCompanyDTO;
import com.atyas.jobmicroservice.job.external.Company;

public class JobMapper {
    public static JobWithCompanyDTO mapToJobWithCompanyDto(
            Job job,
            Company company
    ){
        JobWithCompanyDTO jobWithCompanyDTO = new JobWithCompanyDTO();
        jobWithCompanyDTO.setId(job.getId());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setCompany(company);

        return jobWithCompanyDTO;
    }
}
