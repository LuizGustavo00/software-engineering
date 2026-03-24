package br.inatel.SoftwareEngineer.domain.vehicles;

public enum VehicleType {
    CAR ("car"),
    MOTORCYCLE ("motorcycle"),
    TRUCK ("truck");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type
    }
}
