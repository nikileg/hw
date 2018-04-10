package com.nikileg.hw.entity;

import lombok.Value;
import lombok.experimental.Wither;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Value
@Wither
@Entity
public class Account {
    @Id
    Long id;
    String name;
    Double volume;

    //    @ManyToOne
    //    Owner owner;
    Long ownerId;

}
