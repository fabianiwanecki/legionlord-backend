package com.legionlord.legionlordbackend.controller;

import com.legionlord.legionlordbackend.dto.PlayerByNameResDto;
import com.legionlord.legionlordbackend.dto.PlayerStatsResDto;
import com.legionlord.legionlordbackend.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("players")
public class PlayerController {

    private PlayerService playerService;

    @GetMapping("by-name")
    public PlayerByNameResDto getPlayerByName(@RequestParam String name) {
        return playerService.getPlayerByName(name);
    }

    @GetMapping("{id}/stats")
    public PlayerStatsResDto getPlayerStats(@PathVariable String id) {
        return playerService.getPlayerStats(id);
    }

    @GetMapping("{id}")
    public Object getPlayer(@PathVariable String id) {
        return playerService.getPlayer(id);
    }

    @GetMapping("{id}/match-history")
    public Object getMatchHistory(@PathVariable String id, @RequestParam(defaultValue = "20") Integer limit, @RequestParam(defaultValue = "0") Integer offset) {
        return playerService.getMatchHistory(id, limit, offset);
    }

}
