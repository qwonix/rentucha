package ru.qwonix.android.rentucha.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.qwonix.android.rentucha.dao.RetrofitService
import ru.qwonix.android.rentucha.entity.Apartment

class SearchSettingsViewModel : ViewModel() {
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    private val _adultsCount = MutableLiveData<Int>(0)
    val adultsCount: LiveData<Int> = _adultsCount

    private val _childrenCount = MutableLiveData<Int>(0)
    val childrenCount: LiveData<Int> = _childrenCount

    private val _infantsCount = MutableLiveData<Int>(0)
    val infantsCount: LiveData<Int> = _infantsCount

    private val _petsCount = MutableLiveData<Int>(0)
    val petsCount: LiveData<Int> = _petsCount

    private val _apartments = MutableLiveData<List<Apartment>>(
        listOf<Apartment>(
            Apartment(
                "Россия",
                "Санкт-Петербург",
                4234.21,
                "https://i.imgur.com/8cUWZ9j.jpeg",
                4,
                59.857229, 30.317933
            ), Apartment(
                "Россия",
                "Санкт-Петербург",
                2342.54,
                "https://i.imgur.com/udaZzAd.jpeg",
                5,
                59.873549, 30.307972
            )
        )
    )
    val apartments: LiveData<List<Apartment>> = _apartments
    val apartmentsCount: LiveData<Int> = MutableLiveData<Int>(_apartments.value?.size ?: 0)

    fun requestApartments() {
        val call: Call<MutableList<Apartment>> = RetrofitService.retrofitService.findAll()
        call.enqueue(object : Callback<MutableList<Apartment>?> {
            override fun onResponse(
                call: Call<MutableList<Apartment>?>,
                response: Response<MutableList<Apartment>?>
            ) {
                response.body()?.forEach { println(it) }
                _apartments.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Apartment>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun requestApartmentsByName(name: String) {
        val call: Call<MutableList<Apartment>> = RetrofitService.retrofitService.findAllByName(name)
        call.enqueue(object : Callback<MutableList<Apartment>?> {
            override fun onResponse(
                call: Call<MutableList<Apartment>?>,
                response: Response<MutableList<Apartment>?>
            ) {
                println("requestApartmentsByName")
                response.body()?.forEach { println(it) }
                _apartments.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Apartment>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


    fun addAdult() {
        _adultsCount.postValue(_adultsCount.value?.inc() ?: 0)
    }

    fun addChild() {
        _childrenCount.postValue(_childrenCount.value?.inc() ?: 0)
    }

    fun addInfant() {
        _infantsCount.postValue(_infantsCount.value?.inc() ?: 0)
    }

    fun addPet() {
        _petsCount.postValue(_petsCount.value?.inc() ?: 0)
    }

    fun removeAdult() {
        _adultsCount.postValue(_adultsCount.value?.dec() ?: 0)
    }

    fun removeChild() {
        _childrenCount.postValue(_childrenCount.value?.dec() ?: 0)
    }

    fun removeInfant() {
        _infantsCount.postValue(_infantsCount.value?.dec() ?: 0)
    }

    fun removePet() {
        _petsCount.postValue(_petsCount.value?.dec() ?: 0)
    }

    fun clearSettings() {
        _searchQuery.postValue("")

        _adultsCount.postValue(0)
        _childrenCount.postValue(0)
        _infantsCount.postValue(0)
        _petsCount.postValue(0)
    }

    fun setSearchQuery(searchQuery: String) {
        _searchQuery.postValue(searchQuery)
    }

    fun getSearchBarSettingsDescriptionText(): String {
        return getGuestsCount().toString() + " guests"
    }

    fun getGuestsCount(): Int {
        val guestsCount = listOf(
            _adultsCount.value,
            _childrenCount.value,
            _infantsCount.value,
            _petsCount.value
        )
        var sum = 0
        guestsCount.forEach { if (it != null) sum += it }

        return sum
    }


    fun hasSearchQuery(): Boolean {
        return _searchQuery.value != null && _searchQuery.value?.isNotBlank() ?: false
    }
}