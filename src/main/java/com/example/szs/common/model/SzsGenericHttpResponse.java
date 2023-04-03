package com.example.szs.common.model;

import com.example.szs.common.utils.CommonUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SzsGenericHttpResponse<T> {

    private String status;
    private T data;
    private Map<String, Object> errors;

    @JsonIgnore
    public boolean isSuccess() {
        return CommonUtils.isNotEmpty(status) && "success".equals(status);
    }
}
