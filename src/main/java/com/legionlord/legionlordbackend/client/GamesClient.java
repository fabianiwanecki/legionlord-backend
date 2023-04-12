package com.legionlord.legionlordbackend.client;

import com.legionlord.legionlordbackend.dto.GamesResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "games", url = "https://apiv2.legiontd2.com")
public interface GamesClient {

    @GetMapping("games")
    List<GamesResDto> fetchGames(@RequestParam Integer limit, @RequestParam Integer offset, @RequestParam String queueType,
                                 @RequestParam String sortBy, @RequestParam Integer sortDirection,
                                 @RequestParam Boolean includeDetails, @RequestParam Boolean countResults,
                                 @RequestParam String dateBefore, @RequestParam String dateAfter,
                                 @RequestHeader("x-api-key") String apiKey);

}
