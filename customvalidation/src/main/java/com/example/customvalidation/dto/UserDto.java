package com.example.customvalidation.dto;

import com.example.customvalidation.customvalidator.EnumValid;
import com.example.customvalidation.customvalidator.NotNullIfAnotherFieldHasValue;
import com.example.customvalidation.enums.GenderCode;
import lombok.Getter;

import javax.validation.constraints.*;

@Getter
@NotNullIfAnotherFieldHasValue(
        fieldName = "status",
        expectedFieldValue = "active",
        denpendFieldName = "activeDaysRemaining"
)
public class UserDto {
    @NotBlank
    private String name;

    @Min(15) @Max(90)
    private int age;

    @Email
    private String email;

    @EnumValid(enumClass = GenderCode.class)
    private String gender;

    private String status;

    private Integer activeDaysRemaining;
}
