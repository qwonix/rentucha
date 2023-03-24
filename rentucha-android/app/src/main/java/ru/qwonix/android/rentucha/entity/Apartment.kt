package ru.qwonix.android.rentucha.entity

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit


data class Apartment(
//    var id: Long,
//    var name: String,
//    var description: String,
    var countryName: String,
    var cityName: String,
    var pricePerNight: Double,
    var mainImageUrl: String,
    var maxPersonCount: Int,
    var latitude: Double,
    var longitude: Double,

    var creationTimestamp: LocalDateTime

//    var images: List<String>,

) {
    fun getAddedWeeksAgo(): Long {
        return ChronoUnit.WEEKS.between(
            creationTimestamp,
            LocalDateTime.now()
        )
    }
}