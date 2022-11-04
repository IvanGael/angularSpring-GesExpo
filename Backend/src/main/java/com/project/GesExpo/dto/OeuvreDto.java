package com.project.GesExpo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OeuvreDto {

    private Long id;

    @NotBlank(message = "this field must not be blank")
    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    @Size(min = 4, message = "this field require minimum 4 charaters.")
    private String titre;

    private LocalDate dateCreation;

    @NotNull(message = "this is required field!")
    private Double prix;

    @NotNull(message = "this is required field!")
    private Integer annee;

    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    private String rating;

    @NotEmpty(message = "this field must not be empty")
    @NotNull(message = "this is required field!")
    private String type;

    private String image;
}
