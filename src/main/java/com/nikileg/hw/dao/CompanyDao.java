package com.nikileg.hw.dao;

import com.nikileg.hw.entity.Company;

import java.util.List;

public interface CompanyDao {
    Company getById(Long id);

    List<Company> getAll();

    Company insert(Company company);

    Company update(Company company);
}
