package com.cycling.api.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;

import com.cycling.api.repository.CyclistRepository;
import com.cycling.api.service.ICyclistService;
import com.cycling.api.util.mapper.CyclistMapper;
import com.cycling.api.dto.CyclistDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
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

    @Override
    public Mono<CyclistDto> getCyclistById(String id_cyclist) {
        return cyclistRepository.findById(id_cyclist)
                .map(cyclistMapper
                        .fromCyclistToCyclistDto()
        );
    }
}
