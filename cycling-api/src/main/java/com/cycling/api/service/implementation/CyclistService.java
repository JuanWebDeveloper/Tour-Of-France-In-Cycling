package com.cycling.api.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;

import com.cycling.api.repository.CyclistRepository;
import com.cycling.api.service.ICyclistService;
import com.cycling.api.util.mapper.CyclistMapper;
import com.cycling.api.dto.CyclistDto;
import reactor.core.publisher.Mono;

public class CyclistService implements ICyclistService {
    @Autowired
    private CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public CyclistService() {
        this.cyclistMapper = new CyclistMapper();
    }

    @Override
    public Mono<CyclistDto> createCyclist(CyclistDto cyclistDto) {
        return cyclistRepository.save(cyclistMapper
                        .fromCyclistDtoToCyclist()
                        .apply(cyclistDto))
                .map(cyclistMapper
                        .fromCyclistToCyclistDto()
        );
    }
}
