package com.nikileg.hw.entity;

import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
public class Owner {
    Long id;
    String firstName;
    String secondName;
    Long companyId;
}
