package com.legionlord.legionlordbackend.client;

import com.legionlord.legionlordbackend.dto.PlayerByNameResDto;
import com.legionlord.legionlordbackend.dto.PlayerStatsResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "players", url = "https://apiv2.legiontd2.com")
public interface PlayersClient {

    @GetMapping("players/byName/{name}")
    PlayerByNameResDto getPlayerByName(@PathVariable String name,
                                       @RequestHeader("x-api-key") String apiKey);

    @GetMapping("players/stats/{id}")
    PlayerStatsResDto getPlayerStats(@PathVariable String id,
                                     @RequestHeader("x-api-key") String apiKey);

    @GetMapping("players/byId/{id}")
    Object getPlayer(@PathVariable String id,
                     @RequestHeader("x-api-key") String apiKey);

    @GetMapping("players/matchHistory/{id}")
    Object getMatchHistory(@PathVariable String id,
                           @RequestParam Integer limit,
                           @RequestParam Integer offset,
                           @RequestHeader("x-api-key") String apiKey);

}
