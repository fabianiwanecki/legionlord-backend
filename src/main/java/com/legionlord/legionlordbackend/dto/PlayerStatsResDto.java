package com.legionlord.legionlordbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlayerStatsResDto(
        @JsonProperty("_id") String id,
        Integer collectionValue,
        Integer secondsPlayed,
        Integer totalXp,
        Integer elementXp,
        Integer mastermindPlayed,
        Integer wins,
        Integer winRate,
        Integer mastermindWins,
        Integer rankedWinsThisSeason,
        Integer winStreak,
        Integer lossStreak,
        Integer mastermindXp,
        Integer overallElo,
        Integer overallEloThisSeasonAtLeastOneGamePlayed,
        Integer overallPeakEloForProfileOnly,
        Integer gamesWithoutCard,
        Integer gamesPlayed,
        Integer losses,
        Integer mastermindLosses,
        Integer rankedLossesThisSeason,
        Integer atlanteanElo,
        Integer atlanteanPeakElo,
        Integer atlanteanPeakEloThisSeason,
        Integer behaviorScore,
        Integer casualGamesPlayed,
        Integer casualWins,
        Integer classicElo,
        Integer classicEloThisSeasonAtLeastOneGamePlayed,
        Integer classicLosses,
        Integer classicLossesThisSeason,
        Integer classicPeakElo,
        Integer classicPeakEloThisSeason,
        Integer classicPeakEloThisSeasonAtLeastOneGamePlayed,
        Integer classicWins,
        Integer classicWinsThisSeason,
        Integer divineElo,
        Integer divinePeakElo,
        Integer divinePeakEloThisSeason,
        Integer elementElo,
        Integer elementLosses,
        Integer elementPeakElo,
        Integer elementPeakEloThisSeason,
        Integer elementPlayed,
        Integer elementWins,
        Integer forsakenElo,
        Integer forsakenLosses,
        Integer forsakenPeakElo,
        Integer forsakenPeakEloThisSeason,
        Integer forsakenPlayed,
        Integer forsakenWins,
        Integer forsakenXp,
        Integer groveElo,
        Integer groveLosses,
        Integer grovePeakElo,
        Integer grovePeakEloThisSeason,
        Integer grovePlayed,
        Integer groveWins,
        Integer groveXp,
        Integer mastermindElo,
        Integer mastermindPeakElo,
        Integer mastermindPeakEloThisSeason,
        Integer mechElo,
        Integer mechLosses,
        Integer mechPeakElo,
        Integer mechPeakEloThisSeason,
        Integer mechPlayed,
        Integer mechWins,
        Integer mechXp,
        Integer nomadElo,
        Integer nomadPeakElo,
        Integer nomadPeakEloThisSeason,
        Integer overallPeakElo,
        Integer overallPeakEloLastSeason,
        Integer overallPeakEloThisSeason,
        Integer overallPeakEloThisSeasonAtLeastOneGamePlayed,
        Integer quits,
        Integer ratingAtStartOfSeason,
        Integer shrineElo,
        Integer shrinePeakElo,
        Integer shrinePeakEloThisSeason,
        Integer ties,
        Integer botWins,
        Integer botLosses,
        Integer weeklyChallengeScore,
        Integer featuredElo,
        Integer eventPoints,
        Integer eventPointsPeak,
        Integer cardTraderPity,
        Integer guildContribution,
        Integer guildContributionThisGuild,
        Integer lpGamesThisWeek,
        Integer ladderPoints
) {}
