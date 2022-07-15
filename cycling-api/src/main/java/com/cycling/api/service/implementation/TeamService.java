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
    private final TeamMapper teamMapper;

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

    @Override
    public Mono<TeamDto> getTeamById(String id_team) {
        return teamRepository.findById(id_team)
                .map(teamMapper
                        .fromTeamToTeamDto()
        );
    }

    @Override
    public Mono<TeamDto> updateTeam(TeamDto teamDto) {
        return teamRepository.findById(teamDto.getId_team())
                .flatMap(team -> {
                        team.setName_team(teamDto.getName_team());
                        team.setCode_team(teamDto.getCode_team());
                        team.setCountry_team(teamDto.getCountry_team());
                        return teamRepository.save(team);
                })
                .map(teamMapper
                        .fromTeamToTeamDto()
        );
    }

    @Override
    public Mono<Void> deleteTeam(String id_team) {
        return teamRepository.deleteById(id_team);
    }
}
