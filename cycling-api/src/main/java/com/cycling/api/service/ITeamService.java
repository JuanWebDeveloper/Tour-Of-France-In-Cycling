package com.cycling.api.service;

import com.cycling.api.dto.TeamDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITeamService {
    public Mono<TeamDto> createTeam(TeamDto teamDto);
    public Flux<TeamDto> getAllTeams();
    public Mono<TeamDto> getTeamById(String id);
    public Mono<TeamDto> updateTeam(TeamDto teamDto);
}
