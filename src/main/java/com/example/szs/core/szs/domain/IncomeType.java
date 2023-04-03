package com.example.szs.core.szs.domain;

import com.example.szs.common.utils.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum IncomeType {
    INSU(
        "보험료"
    ),
    EDU(
        "교육비"
    ),
    DONA(
        "기부금"
    ),
    MEDIC(
        "의료비"
    ),
    RETPN(
        "퇴직연금"
    );

    private String description;

    private static final Map<String, IncomeType> incomeTypeHashMap = new HashMap<>();
    static {
        for (IncomeType os : IncomeType.values()) {
            incomeTypeHashMap.put(os.getDescription(), os);
        }
    }
    public static IncomeType getIncomeByDescription(String description) {
        return CommonUtils.isEmpty( description ) ? null : incomeTypeHashMap.get(description);
    }

    public static boolean isRETPN(IncomeType incomeType) {
        return CommonUtils.isNotEmpty(incomeType) && incomeType == RETPN;
    }
}
