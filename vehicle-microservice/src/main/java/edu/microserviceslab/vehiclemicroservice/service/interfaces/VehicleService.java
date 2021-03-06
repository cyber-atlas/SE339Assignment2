package edu.microserviceslab.vehiclemicroservice.service.interfaces;

import edu.microserviceslab.vehiclemicroservice.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAllVehicles();

    Vehicle addVehicle(Vehicle vehicle);

    String getVehicleLicensePlate(Long vehicleId);
}
