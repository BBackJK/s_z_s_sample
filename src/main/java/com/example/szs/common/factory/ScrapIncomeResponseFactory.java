package com.example.szs.common.factory;

import com.example.szs.common.utils.CommonUtils;
import com.example.szs.core.szs.adapter.in.controller.model.ScrapIncomeCommonDto;
import com.example.szs.core.szs.adapter.in.controller.model.ScrapIncomeResponseDto;
import com.example.szs.core.szs.adapter.in.controller.model.ScrapIncomeTotalDto;
import com.example.szs.core.szs.domain.IncomeType;

public class ScrapIncomeResponseFactory {

    public static ScrapIncomeResponseDto getIncome(IncomeType incomeType) {
        return CommonUtils.isEmpty(incomeType)
                ? null
                : getIncome(incomeType.getDescription());
    }

    public static ScrapIncomeResponseDto getIncome(String incomeType) {
        if (CommonUtils.isEmpty(incomeType)) {
            return null;
        }

        switch (incomeType) {
            case "보험료":
            case "교육비":
            case "기부금":
            case "의료비":
                return new ScrapIncomeCommonDto();
            case "퇴직연금":
                return new ScrapIncomeTotalDto();
            default:
                return null;
        }
    }
}
