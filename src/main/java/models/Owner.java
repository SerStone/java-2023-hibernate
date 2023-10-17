package models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor

public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // забув додати cascade
    private List<Car> cars = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drive_license_id", referencedColumnName = "id")
    private DriverLicense driveLicense;

    public Owner(String name, DriverLicense driveLicense) {
        this.name = name;
        this.driveLicense = driveLicense;
    }
}
