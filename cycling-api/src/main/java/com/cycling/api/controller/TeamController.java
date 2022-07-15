package com.cycling.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.cycling.api.service.implementation.TeamService;
import com.cycling.api.dto.TeamDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/create")
    public Mono<ResponseEntity<Mono<TeamDto>>> createTeam(@RequestBody TeamDto teamDto) {
        try {
            return Mono.just(
                    ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(teamService.createTeam(teamDto))
            );
        } catch (Exception e) {
            throw  new RuntimeException("Error creating team");
        }
    }

    @GetMapping("/getTeams")
    public Mono<ResponseEntity<Flux<TeamDto>>> getAllTeams() {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(teamService.getAllTeams())
            );
        } catch (Exception e) {
            throw  new RuntimeException("Error getting teams");
        }
    }
}
