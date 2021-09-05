package com.elotech.peoplecontacts.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
public class ErroDetails {
    private final Date timestamp;
    private final String message;
    private final String details;

    public ErroDetails(Date timestamp, String message, String details)
    {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
