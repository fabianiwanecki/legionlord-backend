package com.legionlord.legionlordbackend.service;

import com.legionlord.legionlordbackend.dto.UnitDto;
import com.legionlord.legionlordbackend.mapper.UnitMapper;
import com.legionlord.legionlordbackend.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UnitService {

    private UnitRepository unitRepository;
    private UnitMapper unitMapper;

    public List<UnitDto> getUnits() {
        return unitMapper.entityToDto(unitRepository.findAll());
    }
}
