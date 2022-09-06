package dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class BookDto {
    private int id;
    @NotEmpty(message = "Please provide the book name")
    private String bookName;
    @Positive(message = "The price should be greater than 0")
    private int price;
    private int authorId;
}
