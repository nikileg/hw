package com.nikileg.hw.controller;

import com.nikileg.hw.dao.AccountDao;
import com.nikileg.hw.dao.OwnerDao;
import com.nikileg.hw.entity.Account;
import com.nikileg.hw.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerDao ownerDao;

    @Autowired
    @Qualifier("jdbc")
    private AccountDao accountDao;

    @GetMapping("/all")
    List<Owner> findAll() {
        return ownerDao.getAll();
    }

    @GetMapping("/{id}")
    Owner findById(@PathVariable("id") Long id) {
        return ownerDao.getById(id);
    }

    @PostMapping("/save")
    Owner save(@RequestBody Owner owner) {
        if (owner.getId() == null) {
            return ownerDao.insert(owner);
        } else {
            return ownerDao.update(owner);
        }
    }

    @GetMapping("/{id}/accounts")
    List<Account> findAccountsByOwnerId(@PathVariable("id") Long id) {
        return findAccountsByOwnerId(id);
    }

}
