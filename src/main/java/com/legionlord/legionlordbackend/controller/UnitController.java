package com.legionlord.legionlordbackend.controller;

import com.legionlord.legionlordbackend.dto.UnitDto;
import com.legionlord.legionlordbackend.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("units")
public class UnitController {

    private UnitService unitService;

    @GetMapping
    public List<UnitDto> getUnits() {
        return unitService.getUnits();
    }

}
