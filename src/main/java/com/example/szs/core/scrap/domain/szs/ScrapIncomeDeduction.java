package com.example.szs.core.scrap.domain.szs;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScrapIncomeDeduction {
    @SerializedName("소득구분")
    private String incomeType;
    @SerializedName(value = "금액", alternate = "총납임금액")
    private String amount;
}
