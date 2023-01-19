package ru.qwonix.android.rentucha.entity


data class Apartment(
//    var id: Long,
//    var name: String,
//    var description: String,
    var countryName: String,
    var cityName: String,
//    var localeName: String,
    var pricePerDay: Double,
//    var personCount: Double,
//    var creationTimestamp: LocalDateTime,
    var mainImageUrl: String,

//     lateinit var images: List<Image>
//     lateinit var amenities: List<Amenity>
    var latitude: Double,
    var longitude: Double


) {

    fun getLocation(): String {
        return "$countryName $cityName"
    }
}
