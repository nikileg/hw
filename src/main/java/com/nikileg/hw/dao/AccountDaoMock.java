package com.nikileg.hw.dao;

import com.nikileg.hw.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AccountDaoMock implements AccountDao {
    private static Map<Long, Account> accounts;

    static {
        accounts = new HashMap<Long, Account>() {{
            put(1L, new Account(1L, "name1", 10.0, 2L));
            put(2L, new Account(2L, "name2", 20.0, 2L));
            put(3L, new Account(3L, "name3", 14.0, 1L));
            put(4L, new Account(4L, "name4", 27.0, 3L));
        }};
    }

    @Override
    public Account getById(Long id) {
        return accounts.get(id);
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public List<Account> getAllByOwnerId(Long ownerId) {
        return accounts.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(acc -> acc.getId().equals(ownerId))
                .collect(Collectors.toList());
    }

    @Override
    public Account insert(Account account) {
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public Account update(Account account) {
        return insert(account);
    }
}
