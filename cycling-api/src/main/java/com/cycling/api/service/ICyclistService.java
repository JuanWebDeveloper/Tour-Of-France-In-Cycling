package com.cycling.api.service;
import reactor.core.publisher.Mono;

import com.cycling.api.dto.CyclistDto;

public interface ICyclistService {
    public Mono<CyclistDto> createCyclist(CyclistDto cyclistDto);
}
