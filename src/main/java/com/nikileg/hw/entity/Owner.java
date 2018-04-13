package com.nikileg.hw.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Owner {
    Long id;
    String firstName;
    String secondName;
    Long companyId;
}
