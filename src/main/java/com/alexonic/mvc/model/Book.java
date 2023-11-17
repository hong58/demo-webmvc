package com.alexonic.mvc.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;

    @NotNull(message = "ISBN is required!")
    private Integer isbn;

    @NotBlank(message = "Title is required!")
    @Size(min = 3, max = 50, message = "Title must be between 3 to 50 characters!")
    private String title;

    @NotBlank(message = "Author is required!")
    private String author;

    @NotBlank(message = "Year is required!")
    private String year;

    @NotNull(message = "Price is required!")
    @Positive(message = "Price must be greater than zero!")
    @Max(value = 10000, message = "Maximum price is USD 10,000!")
    private Double price;
}
