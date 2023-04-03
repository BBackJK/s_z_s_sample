package com.example.szs.core.szs.adapter.out.interfaces;

import com.example.szs.common.model.SzsGenericHttpResponse;
import com.example.szs.common.utils.BigDecimalUtils;
import com.example.szs.common.utils.CommonUtils;
import com.example.szs.common.utils.LocalDateUtils;
import com.example.szs.core.szs.adapter.out.interfaces.model.ScrapIncomeDeductionJsonModel;
import com.example.szs.core.szs.adapter.out.interfaces.model.ScrapJsonListJsonModel;
import com.example.szs.core.szs.adapter.out.interfaces.model.ScrapResponseJsonModel;
import com.example.szs.core.szs.adapter.out.interfaces.model.ScrapSalaryJsonModel;
import com.example.szs.core.szs.domain.IncomeType;
import com.example.szs.core.szs.domain.scrap.*;
import com.example.szs.infrastructure.annotations.DomainMapHelper;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@DomainMapHelper
public class SzsDomainJsonMapHelper {

    ScrapSalary toDomain(ScrapSalaryJsonModel model) {
        return CommonUtils.isEmpty(model)
                ? null
                : ScrapSalary.of(
                        model.getIncomeDetail()
                        , BigDecimalUtils.toBigDecimal(
                                CommonUtils.orElse( model.getTotalPayAmount(), "" ).replaceAll("\\D", "")
                        )
                        , LocalDateUtils.toLocalDate(model.getWorkStartAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT))
                        , model.getBizName()
                        , model.getUserName()
                        , LocalDateUtils.toLocalDate(model.getPayAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT))
                        , LocalDateUtils.toLocalDate(model.getWorkEndAt(), DateTimeFormatter.ofPattern(LocalDateUtils.FORMAT_DATE_DOT))
                        , model.getRegNo()
                        , model.getIncomeType()
                        , model.getBizNo()
                );
    }

    List<ScrapSalary> toSalaryDomain(List<ScrapSalaryJsonModel> modelList) {
        return CommonUtils.isEmpty( modelList )
                ? Collections.emptyList()
                : modelList.stream().map(this::toDomain).collect(Collectors.toList());
    }

    ScrapIncome toDomain(ScrapIncomeDeductionJsonModel model) {
        return CommonUtils.isEmpty( model )
                ? null
                : ScrapIncome.of(
                    IncomeType.getIncomeByDescription(model.getIncomeType())
                    , BigDecimalUtils.toBigDecimal(
                            CommonUtils.orElse(model.getAmount(), "").replaceAll("\\D", "")
                    )
                );
    }

    List<ScrapIncome> toIncomeDomain(List<ScrapIncomeDeductionJsonModel> modelList) {
        return CommonUtils.isEmpty( modelList )
                ? Collections.emptyList()
                : modelList.stream().map(this::toDomain).collect(Collectors.toList());
    }

    ScrapUserInfo toDomain(ScrapJsonListJsonModel model) {
        return CommonUtils.isEmpty( model )
                ? null
                : ScrapUserInfo.of(
                        toSalaryDomain(model.getSalaries())
                        , BigDecimalUtils.toBigDecimal(
                                CommonUtils.orElse(model.getOutputTax(), "").replaceAll("\\D", "")
                        )
                        , toIncomeDomain(model.getIncomeDeductions())
                );
    }

    ScrapResponse toDomain(ScrapResponseJsonModel model) {
        return CommonUtils.isEmpty( model )
                ? null
                : ScrapResponse.of(
                        toDomain(model.getJsonList())
                        , model.getAppVer()
                        , model.getErrMsg()
                        , model.getCompany()
                        , model.getSvcCd()
                        , model.getHostNm()
                        , model.getWorkerReqDt()
                        , model.getWorkerResDt()
                );
    }
}
