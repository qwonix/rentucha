package ru.qwonix.rentucha.api.entity;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;

@Data
@Entity
public class DateInterval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer pricePerDay;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

}
