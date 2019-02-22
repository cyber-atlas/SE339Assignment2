package edu.microserviceslab.usagemicroservice.controller;

import edu.microserviceslab.usagemicroservice.entity.UsageStatistic;
import edu.microserviceslab.usagemicroservice.service.interfaces.UsageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usage")
public class UsageController {

    private UsageService usageService;

    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<UsageStatistic> listAllUsageStatistics() {
        return usageService.getAllUsageStatistics();
    }

    @ResponseBody
    @RequestMapping("/driver/{driverId}")
    public List<UsageStatistic> listAllUsageStatisticsForDriver(@PathVariable("driverId") Long driverId) {
        return usageService.getUsageStatisticsPerDriver(driverId);
    }

    @ResponseBody
    @RequestMapping("/vehicle/{vehicleId}")
    public List<UsageStatistic> listAllUsageStatisticsForVehicle(@PathVariable("vehicleId") Long vehicleId) {
        return usageService.getUsageStatisticsPerVehicle(vehicleId);
    }

    @ResponseBody
    @PostMapping(path = "/add")
    public UsageStatistic addUsageStat(@RequestBody UsageStatistic usageStat){
       if (usageStat == null) {
            throw new IllegalStateException("Please submit valid usage statistics");
        }
        if (usageStat.getVehicleId() == null) {
            throw new IllegalStateException("The driver needs to have a vehicle assigned to him.");
        }
        if (usageStat.getDriverId() == null){
            throw new IllegalStateException("Need a driver id");
        }
        if (usageStat.getDriverFullname()==null){
            throw new IllegalStateException("Need driver full name");
        }

        return usageService.addUsageStatistic(usageStat);
    }


}