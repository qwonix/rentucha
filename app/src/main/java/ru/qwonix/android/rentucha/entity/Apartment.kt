package ru.qwonix.android.rentucha.entity


data class Apartment(
//    var id: Long,
//    var name: String,
//    var description: String,
    var countryName: String,
    var cityName: String,
    var pricePerNight: Double,
    var mainImageUrl: String,
    var maxPersonCount: Double,


    var latitude: Double,
    var longitude: Double,

//    var creationTimestamp: LocalDateTime,
//    var images: List<String>,

) {

    fun getLocation(): String {
        return "$countryName $cityName"
    }
}
