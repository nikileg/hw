package com.nikileg.hw.entity;

import lombok.Value;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Value
@Wither
@Entity
public class Owner {
    @Id
    Long id;
    String firstName;
    String secondName;

//    @OneToMany(mappedBy = "owner")
//    Collection<Account> accounts;

    //    @ManyToOne
//    Company company;
    Long companyId;
}
