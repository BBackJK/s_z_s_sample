package com.example.szs.core.user.application.port.in;

import com.example.szs.common.model.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Value
@EqualsAndHashCode(callSuper = false)
@ToString
public class RegisterUserCommand extends SelfValidating<RegisterUserCommand> {

    @NotEmpty
    String userId;

    @NotEmpty
    String password;

    @NotEmpty
    String name;

    @NotEmpty
    @Pattern(regexp = "\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])-\\d{7}")
    String regNo;

    public RegisterUserCommand(
            String userId
            , String password
            , String name
            , String regNo
    ) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.regNo = regNo;
        this.validate();
    }

    public static RegisterUserCommand of(
            String userId
            , String password
            , String name
            , String regNo
    ) {
        return new RegisterUserCommand(
                userId
                , password
                , name
                , regNo
        );
    }
}
