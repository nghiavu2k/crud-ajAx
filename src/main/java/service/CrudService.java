package service;

import model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CrudRepository;

@Service
public class CrudService implements IService{
    @Autowired
    private CrudRepository crudRepository;

    public Iterable<Company> getCompanyList() {
        return crudRepository.findAll();
    }

    public Company getCompanyById(Integer id) {
        return crudRepository.findOne(id);
    }

    public void saveOrUpdateCompany(Company company) {
        crudRepository.save(company);
    }

    public void deleteCompany(Integer id) {
        crudRepository.delete(id);
    }
}
