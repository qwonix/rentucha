package ru.qwonix.android.rentucha.viewmodel

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

    val apartmentsCount = MutableLiveData<Int>(0)

    private val _apartments = MutableLiveData<List<Apartment>>(emptyList())
    val apartments: LiveData<List<Apartment>> = _apartments

    fun requestApartments() {
        RetrofitService.retrofitService.findAll()
            .enqueue(object : Callback<MutableList<Apartment>?> {
                override fun onResponse(
                    call: Call<MutableList<Apartment>?>,
                    response: Response<MutableList<Apartment>?>
                ) {
                    _apartments.postValue(response.body())
                }

                override fun onFailure(call: Call<MutableList<Apartment>?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

    fun requestApartmentsByName(name: String) {
        RetrofitService.retrofitService.findAllByName(name)
            .enqueue(object : Callback<MutableList<Apartment>?> {
                override fun onResponse(
                    call: Call<MutableList<Apartment>?>,
                    response: Response<MutableList<Apartment>?>
                ) {
                    _apartments.postValue(response.body())
                }

                override fun onFailure(call: Call<MutableList<Apartment>?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

    fun setSearchQuery(searchQuery: String) {
        _searchQuery.postValue(searchQuery)
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
}