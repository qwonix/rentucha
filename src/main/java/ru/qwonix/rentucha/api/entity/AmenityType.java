package ru.qwonix.rentucha.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AmenityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer priority;
}
