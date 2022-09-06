package dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class AuthorDto {
    private int id;
    @NotEmpty(message = "The name is required.")
    private String authorName;
    @Positive(message = "The age must be greater than 0")
    private int age;
    @NotEmpty(message = "The email address is required.")
    private String email;
}
