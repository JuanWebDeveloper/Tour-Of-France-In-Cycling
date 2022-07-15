package com.cycling.api.service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.cycling.api.dto.CyclistDto;

public interface ICyclistService {
    public Mono<CyclistDto> createCyclist(CyclistDto cyclistDto);
    public Flux<CyclistDto> getAllCyclists();
    public Mono<CyclistDto> getCyclistById(String id_cyclist);
    public Mono<CyclistDto> updateCyclist(CyclistDto cyclistDto);
    public Mono<Void> deleteCyclist(String id_cyclist);

}
