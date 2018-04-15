package com.nikileg.hw.controller;

import com.nikileg.hw.dao.AccountDao;
import com.nikileg.hw.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    @Qualifier("jdbc")
    AccountDao accountDao;

    @GetMapping("/all")
    List<Account> findAll() {
        return accountDao.getAll();
    }

    @GetMapping("/{id}")
    Account findById(@PathVariable("id") Long id) {
        return accountDao.getById(id);
    }

    @PostMapping("/save")
    Account save(@RequestBody Account person) {
        if (person.getId() == null) {
            accountDao.insert(person);
        } else {
            accountDao.update(person);
        }
        return person;
    }
}
