package ru.qwonix.rentucha.api.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2000)
    private String description;

    @Column(nullable = false)
    private String countryName;

    @Column(nullable = false)
    private String cityName;

    @Column
    private String localeName;

    @Column(nullable = false)
    private Double pricePerDay;

    @Column(nullable = false)
    private Double personCount;

    @OneToMany
    @JoinTable(
            name = "apartment_image",
            joinColumns = {@JoinColumn(name = "apartment_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id", referencedColumnName = "id", unique = true)}
    )
    private List<Image> images;

    @ManyToMany
    @JoinTable(
            name = "apartment_amenity",
            joinColumns = {@JoinColumn(name = "apartment_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "amenity_id", referencedColumnName = "id")}
    )
    private List<Amenity> amenities;

    private Double latitude;
    private Double longitude;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationTimestamp;
}
