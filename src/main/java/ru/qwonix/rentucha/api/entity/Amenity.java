package ru.qwonix.rentucha.api.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "amenity_type_id", referencedColumnName = "id")
    private AmenityType amenityType;

    @Column
    private String name;

    @Column
    private String description;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @Column
    private Integer priority;
}
