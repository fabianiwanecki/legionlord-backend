package com.legionlord.legionlordbackend.scheduler;

import com.legionlord.legionlordbackend.client.UnitClient;
import com.legionlord.legionlordbackend.dto.UnitResDto;
import com.legionlord.legionlordbackend.mapper.UnitMapper;
import com.legionlord.legionlordbackend.repository.PatchRepository;
import com.legionlord.legionlordbackend.repository.UnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@EnableAsync
public class UnitFetchScheduler {

    public static final int UNITS_PER_REQUEST = 250;

    private UnitClient unitClient;
    private UnitRepository unitRepository;
    private UnitMapper unitMapper;
    private PatchRepository patchRepository;

    @Async
    @Scheduled(cron = "0 0 0 * * ?")
    public void fetchUnits() {
        System.out.println("Fetching units");

        String patch = patchRepository.findFirstByOrderByCreateTsDesc().orElseThrow(() -> new RuntimeException("Error fetching last patch")).getPatch();
        String version = patch.substring(1);
        List<UnitResDto> units = unitClient.fetchUnits(version, UNITS_PER_REQUEST, 0, null, "M2vIJufiqg1I8iNjXH8d79mSdDLFIGBN8EDGTEeI");

        unitRepository.saveAll(unitMapper.dtoToEntity(units));

        System.out.println("Saved units");
    }
}
