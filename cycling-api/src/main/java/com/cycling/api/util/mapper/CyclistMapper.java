package com.cycling.api.util.mapper;

import com.cycling.api.collection.Cyclist;
import com.cycling.api.dto.CyclistDto;

import java.util.function.Function;

public class CyclistMapper {
    public Function<Cyclist, CyclistDto> fromCyclistToCyclistDto() {
        return cyclist -> {
            CyclistDto cyclistDto = new CyclistDto();
            cyclistDto.setId_cyclist(cyclist.getId_cyclist());
            cyclistDto.setId_team(cyclist.getId_team());
            cyclistDto.setName_cyclist(cyclist.getName_cyclist());
            cyclistDto.setNumber_cyclist(cyclist.getNumber_cyclist());
            cyclistDto.setCountry_cyclist(cyclist.getCountry_cyclist());
            return cyclistDto;
        };
    }

    public Function<CyclistDto, Cyclist> fromCyclistDtoToCyclist() {
        return cyclistDto -> {
            Cyclist cyclist = new Cyclist();
            cyclist.setId_cyclist(cyclistDto.getId_cyclist());
            cyclist.setId_team(cyclistDto.getId_team());
            cyclist.setName_cyclist(cyclistDto.getName_cyclist());
            cyclist.setNumber_cyclist(cyclistDto.getNumber_cyclist());
            cyclist.setCountry_cyclist(cyclistDto.getCountry_cyclist());
            return cyclist;
        };
    }
}
