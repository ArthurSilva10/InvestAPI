package com.ArthurSilva.investAPI.InvestAPI.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class StandardError
{
    private Instant timeStamp;
    private String error;
    private String message;
    private int status;

}
