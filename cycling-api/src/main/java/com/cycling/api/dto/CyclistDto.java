package com.cycling.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CyclistDto {
    @NotNull @NotEmpty
    private String id_cyclist;
    @NotNull @NotEmpty
    private String id_team;
    @NotEmpty
    private String name_cyclist;
    @NotEmpty
    private String number_cyclist;
    @NotEmpty
    private String country_cyclist;

    public CyclistDto(String id_cyclist, String id_team, String name_cyclist, String number_cyclist, String country_cyclist) {
        this.id_cyclist = id_cyclist;
        this.id_team = id_team;
        this.name_cyclist = name_cyclist;
        this.number_cyclist = number_cyclist;
        this.country_cyclist = country_cyclist;
    }
}
