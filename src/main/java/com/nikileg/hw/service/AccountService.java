package com.nikileg.hw.service;

import com.nikileg.hw.dao.AccountDao;
import com.nikileg.hw.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public AccountService() {
    }

    void printAll() {
        accountDao.getAll().forEach(System.out::println);
    }

    void multiplyAll(Double multiplier) {
        accountDao.getAll().stream()
                .map(acc -> acc.withVolume(acc.getVolume() * multiplier))
                .forEach(accountDao::insert);
    }

    void multiplyOwner(Long ownerId, Double multiplier) {
        accountDao.getAllByOwnerId(ownerId).stream()
                .map(acc -> acc.withVolume(acc.getVolume() * multiplier))
                .forEach(accountDao::insert);
    }

    double getTotalVolume() {
        return accountDao.getAll().stream()
                .mapToDouble(Account::getVolume)
                .sum();
    }

    double getTotalOwnerVolume(Long ownerId) {
        return accountDao.getAllByOwnerId(ownerId).stream()
                .mapToDouble(Account::getVolume)
                .sum();
    }
}
