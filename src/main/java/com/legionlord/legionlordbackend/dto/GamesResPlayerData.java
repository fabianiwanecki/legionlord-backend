package com.legionlord.legionlordbackend.dto;

import java.util.List;

public record GamesResPlayerData(String playerId, String playerName, Integer playerSlot, String legion, Integer workers,
                                 Integer value, Boolean cross, String gameResult, Integer overallElo, String fighters,
                                 String mercenaries, Boolean stayedUntilEnd, String chosenSpell,
                                 String chosenSpellLocation, Integer partySize,
                                 String firstWaveFighters, String rolls, Integer legionSpecificElo,
                                 List<String> partyMembers, List<String> partyMembersIds, Integer mvpScore,
                                 List<Integer> netWorthPerWave, List<Integer> workersPerWave,
                                 List<Integer> incomePerWave, List<List<String>> mercenariesSentPerWave,
                                 List<List<String>> mercenariesReceivedPerWave, List<List<String>> leaksPerWave,
                                 List<List<String>> buildPerWave, Integer leakValue, Integer leaksCaughtValue,
                                 Integer leftAtSeconds, List<List<String>> kingUpgradesPerWave,
                                 List<List<String>> opponentKingUpgradesPerWave) {
}
