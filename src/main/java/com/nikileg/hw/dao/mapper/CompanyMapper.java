package com.nikileg.hw.dao.mapper;

import com.nikileg.hw.entity.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {
    @Override
    public Company mapRow(ResultSet rs, int i) throws SQLException {
        return new Company(
                rs.getLong("id"),
                rs.getString("title")
        );
    }
}
