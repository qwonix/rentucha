package ru.qwonix.android.rentucha.dao

import ru.qwonix.android.rentucha.BuildConfig

object RetrofitService {
    private const val BASE_URL = BuildConfig.RENTUCHA_API
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}
