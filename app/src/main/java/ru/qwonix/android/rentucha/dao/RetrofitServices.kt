package ru.qwonix.android.rentucha.dao


import retrofit2.Call
import retrofit2.http.*
import ru.qwonix.android.rentucha.entity.Apartment

interface RetrofitServices {
    @GET("apartments")
    fun findAll(): Call<MutableList<Apartment>>
}