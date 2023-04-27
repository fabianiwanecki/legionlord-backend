package com.legionlord.legionlordbackend.controller;

import com.legionlord.legionlordbackend.dto.*;
import com.legionlord.legionlordbackend.entity.GameType;
import com.legionlord.legionlordbackend.entity.Rank;
import com.legionlord.legionlordbackend.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("statistics")
public class StatisticsController {

    private StatisticsService statisticsService;

    @GetMapping("ending-waves/latest")
    public List<EndingWaveStatisticsDto> getLatestEndingWaveStatistics(@RequestParam("game-type") GameType gameType, @RequestParam Rank rank) {
        return statisticsService.getLatestEndingWaveStatistics(gameType, rank);
    }

    @GetMapping("first-wave-fighters/latest")
    public List<FirstWaveFighterStatisticsDto> getLatestFirstWaveFightersStatistics(@RequestParam("game-type") GameType gameType, @RequestParam Rank rank) {
        return statisticsService.getLatestFirstWaveFightersStatistics(gameType, rank);
    }

    @GetMapping("legions/latest")
    public List<LegionStatisticsDto> getLatestLegionStatistics(@RequestParam("game-type") GameType gameType, @RequestParam Rank rank) {
        return statisticsService.getLatestLegionStatistics(gameType, rank);
    }

    @GetMapping("rolls/latest")
    public List<RollStatisticsDto> getLatestRollStatistics(@RequestParam("game-type") GameType gameType, @RequestParam Rank rank) {
        return statisticsService.getLatestRollStatistics(gameType, rank);
    }

    @GetMapping("spells/latest")
    public List<SpellStatisticsDto> getLatestSpellStatistics(@RequestParam("game-type") GameType gameType, @RequestParam Rank rank) {
        return statisticsService.getLatestSpellStatistics(gameType, rank);
    }

    @GetMapping("units/latest")
    public List<UnitStatisticsDto> getLatestUnitStatistics(@RequestParam("game-type") GameType gameType, @RequestParam Rank rank) {
        return statisticsService.getLatestUnitStatistics(gameType, rank);
    }

}
