package com.meetup.invoice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
public class RestResponse {

    private Integer status;
    private RestError error;

    public RestResponse(HttpStatus status, String title, String description, Collection<String> messages) {
        this.status = status.value();
        this.error = new RestError(title, description, messages);
    }
}