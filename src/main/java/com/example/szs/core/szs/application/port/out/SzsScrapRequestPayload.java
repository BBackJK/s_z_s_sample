package com.example.szs.core.szs.application.port.out;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class SzsScrapRequestPayload {
    String name;
    String regNo;

    public static SzsScrapRequestPayload of(String name, String regNo1, String regNo2) {
        return of(name, String.format("%s-%s", regNo1, regNo2));
    }

    public static SzsScrapRequestPayload of(String name, String regNo) {
        return new SzsScrapRequestPayload(
                name
                , regNo
        );
    }
}
