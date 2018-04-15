package com.nikileg.hw.controller;

import com.nikileg.hw.dao.CompanyDao;
import com.nikileg.hw.dao.OwnerDao;
import com.nikileg.hw.entity.Company;
import com.nikileg.hw.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private OwnerDao ownerDao;

    @GetMapping("/all")
    List<Company> findAll() {
        return companyDao.getAll();
    }

    @GetMapping("/{id}")
    Company findById(@PathVariable("id") Long id) {
        return companyDao.getById(id);
    }

    @PostMapping("/save")
    Company save(@RequestBody Company company) {
        if (company.getId() == null) {
            return companyDao.insert(company);
        } else {
            return companyDao.update(company);
        }
    }

    @GetMapping("/{id}/owners")
    List<Owner> findOwnersByCompanyId(@PathVariable("id") Long id) {
        return ownerDao.getAllByCompanyId(id);
    }
}
