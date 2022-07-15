package com.cycling.api.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.cycling.api.service.ITeamService;
import com.cycling.api.repository.TeamRepository;
import com.cycling.api.util.mapper.TeamMapper;
import com.cycling.api.dto.TeamDto;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private TeamRepository teamRepository;
    private TeamMapper teamMapper;

    public TeamService() {
        this.teamMapper = new TeamMapper();
    }

    @Override
    public Mono<TeamDto> createTeam(TeamDto teamDto) {
        return teamRepository.save(teamMapper
                        .fromTeamDtoToTeam()
                        .apply(teamDto))
                .map(teamMapper
                        .fromTeamToTeamDto()
        );
    }

    @Override
    public Flux<TeamDto> getAllTeams() {
        return teamRepository.findAll()
                .map(team -> teamMapper
                        .fromTeamToTeamDto()
                        .apply(team)
        );
    }
}
