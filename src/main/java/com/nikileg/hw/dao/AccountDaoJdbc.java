package com.nikileg.hw.dao;

import com.nikileg.hw.dao.mapper.AccountMapper;
import com.nikileg.hw.entity.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jdbc")
public class AccountDaoJdbc implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public AccountDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getById(Long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        List<Account> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new AccountMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    @Override
    public List<Account> getAll() {
        String sql = "SELECT * FROM account";
        List<Account> entities = jdbcTemplate.query(sql, new AccountMapper());
        return entities;
    }

    @Override
    public List<Account> getAllByOwnerId(Long ownerId) {
        String sql = "SELECT * FROM account where owner_id = ?";
        List<Account> entities = jdbcTemplate.query(sql, new Object[]{ownerId}, new AccountMapper());
        return entities.isEmpty() ? null : entities;
    }

    @Override
    public Account insert(Account account) {
        String sql = "INSERT INTO account (name, volume, owner_id) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql,
                account.getName(),
                account.getVolume(),
                account.getOwnerId(),
                keyHolder
        );
        Long id = keyHolder.getKey().longValue();
        return account.withId(id);
    }

    @Override
    public Account update(Account account) {
        String sql = "INSERT INTO account (name, volume, owner_id) VALUES (?, ?, ?) where id = ?";
        jdbcTemplate.update(sql,
                account.getName(),
                account.getVolume(),
                account.getOwnerId(),
                account.getId()
        );
        return account;
    }
}
