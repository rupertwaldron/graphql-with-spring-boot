package com.ruppyrup.graphql.dataloader;

import com.ruppyrup.graphql.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class VehicleDataLoader {
    private final static Logger logger = LoggerFactory.getLogger(VehicleDataLoader.class);
    private final VehicleService vehicleService;

    @Autowired
    public VehicleDataLoader(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    private void generateData() {
        vehicleService.createVehicle("car", "430d", "BMW", LocalDate.now().toString());
        vehicleService.createVehicle("car", "330e", "BMW", LocalDate.now().toString());
        vehicleService.createVehicle("car", "MX5", "Mazda", LocalDate.now().toString());
        vehicleService.createVehicle("car", "Fiesta", "Ford", LocalDate.now().toString());
        logger.info("Vehicles have been loaded");
    }
}
