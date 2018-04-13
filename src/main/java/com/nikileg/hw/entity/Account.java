package com.nikileg.hw.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

import java.io.Serializable;

@Value
@Wither
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Account implements Serializable {
    Long id;
    String name;
    Double volume;
    Long ownerId;
}
