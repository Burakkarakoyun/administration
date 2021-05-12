package com.school.administration.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class ResponseData {

    @Getter
    @Setter
    private Object item;

    @Getter @Setter
    private List<?> items;

}

