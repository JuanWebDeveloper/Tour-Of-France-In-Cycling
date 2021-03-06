package com.cycling.api.service.implementation;
import org.springframework.beans.factory.annotation.Autowired;

import com.cycling.api.repository.CyclistRepository;
import com.cycling.api.service.ICyclistService;
import com.cycling.api.util.mapper.CyclistMapper;
import com.cycling.api.dto.CyclistDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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
    public Flux<CyclistDto> getAllCyclists() {
        return cyclistRepository.findAll()
                .map(cyclist -> cyclistMapper
                        .fromCyclistToCyclistDto()
                        .apply(cyclist)
        );
    }

    @Override
    public Mono<CyclistDto> getCyclistById(String id_cyclist) {
        return cyclistRepository.findById(id_cyclist)
                .map(cyclistMapper
                        .fromCyclistToCyclistDto()
        );
    }

    @Override
    public Mono<CyclistDto> updateCyclist(CyclistDto cyclistDto) {
        return cyclistRepository.findById(cyclistDto.getId_cyclist())
                .flatMap(cyclist -> {
                        cyclist.setName_cyclist(cyclistDto.getName_cyclist());
                        cyclist.setNumber_cyclist(cyclistDto.getNumber_cyclist());
                        cyclist.setCountry_cyclist(cyclistDto.getCountry_cyclist());
                        return cyclistRepository.save(cyclist);
                })
                .map(cyclistMapper
                        .fromCyclistToCyclistDto()
        );
    }

    @Override
    public Mono<Void> deleteCyclist(String id_cyclist) {
        return cyclistRepository.deleteById(id_cyclist);
    }
}
