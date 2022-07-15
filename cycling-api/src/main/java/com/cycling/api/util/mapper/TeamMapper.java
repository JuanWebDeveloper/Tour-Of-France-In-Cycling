package com.cycling.api.util.mapper;

import java.util.function.Function;

import com.cycling.api.collection.Team;
import com.cycling.api.dto.TeamDto;

public class TeamMapper {
    public Function<Team, TeamDto> fromTeamToTeamDto() {
        return  team -> {
            TeamDto teamDto = new TeamDto();
            teamDto.setId_team(team.getId_team());
            teamDto.setName_team(team.getName_team());
            teamDto.setCode_team(team.getCode_team());
            teamDto.setCountry_team(team.getCountry_team());
            return teamDto;
        };
    }

    public Function<TeamDto, Team> fromTeamDtoToTeam() {
        return teamDto -> {
            Team team = new Team();
            team.setId_team(teamDto.getId_team());
            team.setName_team(teamDto.getName_team());
            team.setCode_team(teamDto.getCode_team());
            team.setCountry_team(teamDto.getCountry_team());
            return team;
        };
    }
}
