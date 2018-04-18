package com.nikileg.hw.dao.mapper;

import com.nikileg.hw.entity.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet rs, int i) throws SQLException {
        return new Owner(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("second_name"),
                rs.getLong("company_id")
        );
    }
}
