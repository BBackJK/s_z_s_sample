package com.example.szs.core.szs.adapter.out.interfaces.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScrapSalaryJsonModel {
    @SerializedName("소득내역")
    private String incomeDetail;
    @SerializedName("총지급액")
    private String totalPayAmount;
    @SerializedName("업무시작일")
    private String workStartAt;
    @SerializedName("기업명")
    private String bizName;
    @SerializedName("이름")
    private String userName;
    @SerializedName("지급일")
    private String payAt;
    @SerializedName("업무종료일")
    private String workEndAt;
    @SerializedName("주민등록번호")
    private String regNo;
    @SerializedName("소득구분")
    private String incomeType;
    @SerializedName("사업자등록번호")
    private String bizNo;
}
