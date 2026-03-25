package br.inatel.SoftwareEngineer.repository;

import br.inatel.SoftwareEngineer.domain.vehicles.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}

