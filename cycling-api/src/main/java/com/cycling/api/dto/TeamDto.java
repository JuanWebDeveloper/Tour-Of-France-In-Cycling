package com.cycling.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class TeamDto {
    @NotEmpty @NotNull
    private String id_team;
    @NotEmpty
    private String name_team;
    @NotEmpty
    private String code_team;
    @NotEmpty
    private String country_team;

    public TeamDto(String id_team, String name_team, String code_team, String country_team) {
        this.id_team = id_team;
        this.name_team = name_team;
        this.code_team = code_team;
        this.country_team = country_team;
    }
}
