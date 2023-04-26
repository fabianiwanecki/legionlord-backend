package com.legionlord.legionlordbackend.repository;

import com.legionlord.legionlordbackend.entity.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<StatisticsEntity, String> {

    @Query(value = "with games_filtered as (select * from games " +
            "where queue_type = :queueName " +
            "and game_elo >= :minElo " +
            "and game_elo <= :maxElo " +
            "and patch_version = :patch) " +
            "select ending_wave as id, count(ending_wave) as wins, (select count(*) from games_filtered) as total " +
            "from games_filtered " +
            "group by ending_wave", nativeQuery = true)
    List<StatisticsEntity> fetchEndingWaveStatistics(int minElo, int maxElo, String queueName, String patch);

    @Query(value = "with player_data_filtered as (select * " +
            "                              from games, " +
            "                                   games_player_data " +
            "                              where queue_type = :queueName " +
            "                                and game_elo >= :minElo " +
            "                                and game_elo <= :maxElo " +
            "                                and patch_version = :patch " +
            "                                and game_result != 'tied' " +
            "                                and games.id = games_player_data.game_id) " +
            "select pd_all.legion as id, count(pd_all.legion) as total, wins " +
            "from player_data_filtered pd_all " +
            "         join (select legion, count(legion) as wins " +
            "               from player_data_filtered " +
            "               where game_result = 'won' " +
            "               group by legion) l_wins on l_wins.legion = pd_all.legion " +
            "group by pd_all.legion, wins", nativeQuery = true)
    List<StatisticsEntity> fetchLegionStatistics(int minElo, int maxElo, String queueName, String patch);

    @Query(value = "with player_data_filtered as (select * " +
            "                              from games, " +
            "                                   games_player_data " +
            "                              where queue_type = :queueName " +
            "                                and game_elo >= :minElo " +
            "                                and game_elo <= :maxElo " +
            "                                and patch_version = :patch " +
            "                                and game_result != 'tied' " +
            "                                and games.id = games_player_data.game_id) " +
            "select pd_all.chosen_spell as id, count(pd_all.chosen_spell) as total, wins " +
            "from player_data_filtered pd_all " +
            "         join (select chosen_spell, count(chosen_spell) as wins " +
            "               from player_data_filtered " +
            "               where game_result = 'won' " +
            "               group by chosen_spell) s_wins on s_wins.chosen_spell = pd_all.chosen_spell " +
            "group by pd_all.chosen_spell, wins", nativeQuery = true)
    List<StatisticsEntity> fetchSpellStatistics(int minElo, int maxElo, String queueName, String patch);
    
    @Query(value = "with player_data_filtered as (select * " +
            "                              from games, " +
            "                                   games_player_data " +
            "                              where queue_type = :queueName " +
            "                                and game_elo >= :minElo " +
            "                                and game_elo <= :maxElo " +
            "                                and patch_version = :patch " +
            "                                and game_result != 'tied' " +
            "                                and games.id = games_player_data.game_id) " +
            "select pd_all.first_wave_fighters as id, count(pd_all.first_wave_fighters) total, wins " +
            "from player_data_filtered pd_all " +
            "         join (select first_wave_fighters, count(first_wave_fighters) as wins " +
            "               from player_data_filtered " +
            "               where game_result = 'won' " +
            "               group by first_wave_fighters) s_wins on s_wins.first_wave_fighters = pd_all.first_wave_fighters " +
            "group by pd_all.first_wave_fighters, wins", nativeQuery = true)
    List<StatisticsEntity> fetchFirstWaveFighterStatistics(int minElo, int maxElo, String queueName, String patch);
    
    @Query(value = "with rolls as (select *, unnest(rolls) roll " +
            "               from games, " +
            "                    games_player_data " +
            "               where queue_type = :queueName " +
            "                 and game_elo >= :minElo " +
            "                 and game_elo <= :maxElo " +
            "                 and patch_version = :patch " +
            "                 and game_result != 'tied' " +
            "                 and games.id = games_player_data.game_id) " +
            "select pd_all.roll as id, total, wins " +
            "from (select roll, count(roll) as total " +
            "      from rolls " +
            "      group by roll) pd_all " +
            "         join (select roll, count(roll) as wins " +
            "               from rolls " +
            "               where game_result = 'won' " +
            "               group by roll) pd_won on pd_all.roll = pd_won.roll " +
            "where pd_all.roll != '' " +
            "group by pd_all.roll, total, wins", nativeQuery = true)
    List<StatisticsEntity> fetchRollStatistics(int minElo, int maxElo, String queueName, String patch);

    @Query(value = "with units as ( " +
            "    select distinct uuid, unnest(fighters) unit, game_result " +
            "    from games, " +
            "                    games_player_data " +
            "               where queue_type = :queueName " +
            "                 and game_elo >= :minElo " +
            "                 and game_elo <= :maxElo " +
            "                 and patch_version = :patch " +
            "                 and game_result != 'tied' " +
            "                 and games.id = games_player_data.game_id) " +
            "select pd_all.unit as id, count(pd_all.unit) as total, wins " +
            "from units pd_all " +
            "         join (select unit, count(unit) as wins " +
            "               from units " +
            "               where game_result = 'won' " +
            "               group by unit) s_wins on s_wins.unit = pd_all.unit " +
            "group by pd_all.unit, wins", nativeQuery = true)
    List<StatisticsEntity> fetchUnitStatistics(int minElo, int maxElo, String queueName, String patch);
}
