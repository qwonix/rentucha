package ru.qwonix.rentucha.api.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
public class ApartmentCalendar {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    private Apartment apartment;

    @Column
    @OneToMany
    @JoinTable(
            name = "apartment_calendar_date_interval",
            joinColumns = {@JoinColumn(name = "apartment_calendar_id", referencedColumnName = "apartment_id")},
            inverseJoinColumns = {@JoinColumn(name = "date_interval_id", referencedColumnName = "id", unique = true)}
    )
    private List<DateInterval> dateIntervalList;
}
