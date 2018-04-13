package com.nikileg.hw.controller;

import com.nikileg.hw.dao.AccountDao;
import com.nikileg.hw.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountDao accountDao;

    @GetMapping("all")
    List<Account> findAll() {
        return accountDao.getAll();
    }

    @GetMapping("/{id}")
    Account findById(@PathVariable("id") Long id) {
        return accountDao.getById(id);
    }

    @PostMapping("/save")
    Account save(@RequestBody Account person) {
        accountDao.insert(person);
        return person;
    }

    @GetMapping("/test")
    String test() {
        return "this is just a testing string";
    }
}
