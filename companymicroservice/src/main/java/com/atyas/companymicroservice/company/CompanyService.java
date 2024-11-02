package com.atyas.companymicroservice.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();



    boolean updateCompany(Company company, Long id);

    Company getCompanyById(Long id);
    void createCompany(Company company);


    List<Company> findAll();

    boolean deleteCompanyById(Long id);
}
