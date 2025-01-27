package com.example.luziano.domain.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseResponse {
    private Integer status;
    private Object data;
}
