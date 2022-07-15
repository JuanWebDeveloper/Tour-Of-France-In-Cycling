package com.cycling.api.service.implementation;
import com.cycling.api.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import com.cycling.api.service.ITeamService;
import com.cycling.api.repository.TeamRepository;
import com.cycling.api.util.mapper.TeamMapper;

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
}
