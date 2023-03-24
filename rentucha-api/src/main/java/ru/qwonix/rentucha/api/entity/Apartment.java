package ru.qwonix.rentucha.api.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private Double pricePerNight;

    @Column(nullable = false)
    private Double maxPersonCount;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column
    private String mainImageUrl;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationTimestamp;
}
