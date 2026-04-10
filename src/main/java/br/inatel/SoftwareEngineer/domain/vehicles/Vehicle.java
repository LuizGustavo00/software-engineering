package br.inatel.SoftwareEngineer.domain.vehicles;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Plate is required")
    @Pattern(regexp = "^[A-Z]{3}-\\d{4}$", message = "Plate must be in the format AAA-0000")
    private String plate;

    @NotNull(message = "Vehicle type is required")
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @NotNull(message = "Number of axles is required")
    @Min(value = 2, message = "Number of axles must be at least 2")
    @Max(value = 9, message = "Number of axles must be at most 9")
    private Integer axles;

    @NotNull(message = "Emergency flag is required")
    private Boolean is_emergency;

    private LocalDateTime created_at;

    public Vehicle(String plate, VehicleType type, Integer axles, Boolean is_emergency) {
        this.plate = plate;
        this.type = type;
        this.axles = axles;
        this.is_emergency = is_emergency;
    }
}
