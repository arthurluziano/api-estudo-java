package com.example.luziano.domain.base;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseResponse {
    private Integer status;
    @Nullable
    private Object data;
}
