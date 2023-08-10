package com.legionlord.legionlordbackend.service;

import com.legionlord.legionlordbackend.client.PlayersClient;
import com.legionlord.legionlordbackend.dto.PlayerByNameResDto;
import com.legionlord.legionlordbackend.dto.PlayerStatsResDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PlayerService {

    public static final String API_KEY = "M2vIJufiqg1I8iNjXH8d79mSdDLFIGBN8EDGTEeI";
    private PlayersClient playersClient;

    public PlayerByNameResDto getPlayerByName(String name) {
        return playersClient.getPlayerByName(name, API_KEY);
    }

    public PlayerStatsResDto getPlayerStats(String id) {
        return playersClient.getPlayerStats(id, API_KEY);
    }

    public Object getPlayer(String id) {
        return playersClient.getPlayer(id, API_KEY);
    }

    public Object getMatchHistory(String id, Integer limit, Integer offset) {
        return playersClient.getMatchHistory(id, limit, offset, API_KEY);
    }
}
