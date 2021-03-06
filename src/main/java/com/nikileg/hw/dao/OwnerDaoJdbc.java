package com.nikileg.hw.dao;

import com.nikileg.hw.dao.mapper.OwnerMapper;
import com.nikileg.hw.entity.Owner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class OwnerDaoJdbc implements OwnerDao {

    private JdbcTemplate jdbcTemplate;

    public OwnerDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Owner getById(Long id) {
        String sql = "SELECT * FROM owner WHERE id = ?";
        List<Owner> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new OwnerMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    @Override
    public List<Owner> getAll() {
        String sql = "SELECT * FROM owner";
        List<Owner> entities = jdbcTemplate.query(sql, new OwnerMapper());
        return entities;
    }

    @Override
    public List<Owner> getAllByCompanyId(Long companyId) {
        String sql = "SELECT * FROM owner WHERE company_id = ?";
        List<Owner> entities = jdbcTemplate.query(
                sql, new Object[]{companyId}, new OwnerMapper());
        return entities;
    }

    @Override
    public Owner insert(Owner owner) {
        String sql = "INSERT INTO owner (first_name, second_name, company_id) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                    ps.setString(1, owner.getFirstName());
                    ps.setString(2, owner.getSecondName());
                    ps.setLong(3, owner.getCompanyId());
                    return ps;
                },
                keyHolder
        );
        Long id = keyHolder.getKey().longValue();
        return owner.withId(id);
    }

    @Override
    public Owner update(Owner owner) {
        String sql = "UPDATE owner SET (first_name, second_name, company_id) = (?, ?, ?) WHERE id = ?";
        jdbcTemplate.update(sql,
                owner.getFirstName(),
                owner.getSecondName(),
                owner.getCompanyId(),
                owner.getId()
        );
        return owner;
    }
}
