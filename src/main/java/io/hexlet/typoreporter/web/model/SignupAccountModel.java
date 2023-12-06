package io.hexlet.typoreporter.web.model;

import io.hexlet.typoreporter.domain.account.constraint.AccountPassword;
import io.hexlet.typoreporter.domain.account.constraint.AccountUsername;
import io.hexlet.typoreporter.service.dto.FieldMatchConsiderCase;
import io.hexlet.typoreporter.service.dto.FieldMatchIgnoreCase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@FieldMatch.List({
//    @FieldMatch(first = "password", second = "confirmPassword", message = "The password and it confirmation must match"),
//    @FieldMatch(first = "email", second = "confirmEmail", message = "The email \"{0}\" and it confirmation \"{1}\" must match")
//})
@FieldMatchConsiderCase(first = "password", second = "confirmPassword", message = "The password and it confirmation must match")
//my add
//@FieldMatchIgnoreCase(first = "email", second = "confirmEmail", message = "The email \"{0}\" and it confirmation \"{1}\" must match")
//my add end

@ToString
public class SignupAccountModel {

    @AccountUsername
    private String username;

    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "The email \"{0}\" incorrect")
    private String email;

    //my add
//    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "The email \"{0}\" incorrect")
//    private String confirmEmail;
    //my add end

    @AccountPassword
    @ToString.Exclude
    private String password;

    @AccountPassword
    @ToString.Exclude
    private String confirmPassword;

    @NotBlank
    @Size(min = 1, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 50)
    private String lastName;
}
