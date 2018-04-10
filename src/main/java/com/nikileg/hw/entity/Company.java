package com.nikileg.hw.entity;

import lombok.Value;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Value
@Wither
@Entity
public class Company {
    @Id
    Long id;
    String title;

//    @OneToMany(mappedBy = "company")
//    Collection<Owner> accountOwners;
}
