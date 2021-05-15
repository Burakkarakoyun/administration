package com.school.administration.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class StudentAddRequest {
    //@NonNull null mu kontrol et
    private String studentName;
    private String studentSurname;
    private double studentEcts;
}
