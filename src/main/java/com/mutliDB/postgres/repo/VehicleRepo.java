package com.mutliDB.postgres.repo;

import com.mutliDB.postgres.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Integer> {
}
