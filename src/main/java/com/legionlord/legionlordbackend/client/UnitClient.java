package com.legionlord.legionlordbackend.client;

import com.legionlord.legionlordbackend.dto.UnitResDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "units", url = "https://apiv2.legiontd2.com")
public interface UnitClient {

    @GetMapping("units/byVersion/{version}")
    List<UnitResDto> fetchUnits(@PathVariable String version, @RequestParam Integer limit,
                                @RequestParam Integer offset, @RequestParam Boolean enabled,
                                @RequestHeader("x-api-key") String apiKey);
}
