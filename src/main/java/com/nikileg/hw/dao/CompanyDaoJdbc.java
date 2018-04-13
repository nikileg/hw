package com.nikileg.hw.dao;

import com.nikileg.hw.dao.mapper.CompanyMapper;
import com.nikileg.hw.entity.Company;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoJdbc implements CompanyDao {

    private JdbcTemplate jdbcTemplate;

    public CompanyDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Company getById(Long id) {
        String sql = "SELECT * FROM company WHERE id = ?";
        Company result = jdbcTemplate.queryForObject(
                sql, new Object[]{id}, new CompanyMapper());
        return result;
    }

    @Override
    public List<Company> getAll() {
        String sql = "SELECT * FROM company";
        List<Company> entities = jdbcTemplate.query(sql, new CompanyMapper());
        return entities;
    }

    @Override
    public Company insert(Company company) {
        String sql = "INSERT INTO company (title) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql,
                company.getTitle(),
                keyHolder
        );
        Long id = keyHolder.getKey().longValue();
        return company.withId(id);
    }

    @Override
    public Company update(Company company) {
        String sql = "INSERT INTO company (title) VALUES (?) WHERE id = ?";
        jdbcTemplate.update(sql,
                company.getTitle(),
                company.getId()
        );
        return company;
    }
}
