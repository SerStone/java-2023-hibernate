package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor

public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int power;
    private int price;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Owner owner;

    public Car(String model, Type type, int power, int price, int year, Owner owner) {
        this.model = model;
        this.type = type;
        this.power = power;
        this.price = price;
        this.year = year;
        this.owner = owner;
    }
}
