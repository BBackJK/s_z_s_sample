package com.example.szs.core.scrap.domain.szs;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScrapJsonList {

    @SerializedName("급여")
    private List<ScrapSalary> salaries;

    @SerializedName("산출세액")
    private String outputTax;

    @SerializedName("소득공제")
    private List<ScrapIncomeDeduction> incomeDeductions;

}
