package controller;

import model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IService;


@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private IService crudService;

    @GetMapping("/list")
    public ModelAndView listCompany() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("company", crudService.getCompanyList());
        return modelAndView;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Company>> getCompanyList() {
        return new ResponseEntity<>(crudService.getCompanyList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Integer id) {
        return new ResponseEntity<>(crudService.getCompanyById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveOrUpdateCompany(@RequestBody Company company) {
        crudService.saveOrUpdateCompany(company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id) {
        crudService.deleteCompany(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
