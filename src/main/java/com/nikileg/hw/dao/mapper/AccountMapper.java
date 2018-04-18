package com.nikileg.hw.dao.mapper;

import com.nikileg.hw.entity.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        return new Account(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("volume"),
                rs.getLong("owner_id")
        );
    }
}
