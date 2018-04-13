package com.nikileg.hw.entity;

import lombok.Value;
import lombok.experimental.Wither;

@Value
@Wither
public class Company {
    Long id;
    String title;
}
