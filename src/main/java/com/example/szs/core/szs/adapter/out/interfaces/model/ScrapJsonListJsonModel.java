package com.example.szs.core.szs.adapter.out.interfaces.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScrapJsonListJsonModel {

    @SerializedName("급여")
    private List<ScrapSalaryJsonModel> salaries;

    @SerializedName("산출세액")
    private String outputTax;

    @SerializedName("소득공제")
    private List<ScrapIncomeDeductionJsonModel> incomeDeductions;

}
