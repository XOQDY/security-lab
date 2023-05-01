package ku.book.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class SignupDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank(message = "First name is required")
    private String name;
}
