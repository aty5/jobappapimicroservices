package com.atyas.companymicroservice.company.impl;

import com.atyas.companymicroservice.company.Company;
import com.atyas.companymicroservice.company.CompanyRepository;
import com.atyas.companymicroservice.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {

            Company companyToUpdate = companyOptional.get();

            companyToUpdate.setName(updatedCompany.getName());
            companyToUpdate.setDescription(updatedCompany.getDescription());

            // avant architecture MS
            //companyToUpdate.setJobs(updatedCompany.getJobs());

            companyRepository.save(companyToUpdate);

            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {

        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
