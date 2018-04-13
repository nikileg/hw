package com.nikileg.hw.entity;

import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
public class Account {
    Long id;
    String name;
    Double volume;
    Long ownerId;
}
