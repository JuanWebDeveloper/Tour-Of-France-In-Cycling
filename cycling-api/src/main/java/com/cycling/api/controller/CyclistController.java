package com.cycling.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import com.cycling.api.service.implementation.CyclistService;
import com.cycling.api.dto.CyclistDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cyclist")
public class CyclistController {
    @Autowired
    private CyclistService cyclistService;

    @PostMapping("/create")
    public Mono<ResponseEntity<Mono<CyclistDto>>> createCyclist(@RequestBody CyclistDto cyclistDto) {
        try {
            return Mono.just(
                    ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(cyclistService.createCyclist(cyclistDto))
            );
        } catch (Exception e) {
            throw  new RuntimeException("Error creating cyclist");
        }
    }

    @GetMapping("/getCyclist/{id_cyclist}")
    public Mono<ResponseEntity<Mono<CyclistDto>>> getCyclistById(@PathVariable("id_cyclist") String id_cyclist) {
        try {
            return Mono.just(
                    ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(cyclistService.getCyclistById(id_cyclist))
            );
        } catch (Exception e) {
            throw  new RuntimeException("Error getting cyclist");
        }
    }

}
