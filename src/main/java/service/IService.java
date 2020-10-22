package service;

import model.Company;

public interface IService {
    Iterable<Company> getCompanyList();

    Company getCompanyById(Integer id);

    void saveOrUpdateCompany(Company company);

    void deleteCompany(Integer id);
}
