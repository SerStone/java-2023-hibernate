package models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class DriverLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String series;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "driveLicense", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Owner owner;

    public DriverLicense(String series) {
        this.series = series;
    }
}
