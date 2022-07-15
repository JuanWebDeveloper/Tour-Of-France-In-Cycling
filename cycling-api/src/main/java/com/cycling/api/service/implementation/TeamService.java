package com.cycling.api.service.implementation;
import com.cycling.api.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import com.cycling.api.repository.TeamRepository;
import com.cycling.api.util.mapper.TeamMapper;

public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    private TeamMapper teamMapper;

    public TeamService() {
        this.teamMapper = new TeamMapper();
    }

    public Mono<TeamDto> createTeam(TeamDto teamDto) {
        return teamRepository.save(teamMapper.fromTeamDtoToTeam().apply(teamDto)).map(teamMapper.fromTeamToTeamDto());
    }
}
