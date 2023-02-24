package ru.qwonix.android.rentucha.dao

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder().registerTypeAdapter(
                            LocalDateTime::class.java,
                            JsonDeserializer<Any?> { json, _, _ ->
                                LocalDateTime.parse(json.asString, DateTimeFormatter.ISO_DATE_TIME)
                            }).create()
                    )
                )

                .build()
        }
        return retrofit!!

    }

//    companion object {
//
//        val BASE_URL = "https://api.github.com/search/"
//
//        fun getRetroInstance(): Retrofit {
//
//            return Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//    }
}