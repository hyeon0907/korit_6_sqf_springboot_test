package com.study.tdd.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RespSaveDto {
    private Boolean isSaveSuccess;
    private String message;
}
