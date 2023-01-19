package ru.qwonix.android.rentucha.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
                "https://i.imgur.com/8cUWZ9j.jpeg"
            ), Apartment(
                "Россия",
                "Санкт-Петербург",
                2342.54,
                "https://i.imgur.com/udaZzAd.jpeg"
            )
        )
    )
    val apartments: LiveData<List<Apartment>> = _apartments

    fun getApartmentsCount(): Int {
        return _apartments.value?.size ?: 0
    }

    fun addAdult() {
        _adultsCount.postValue(_adultsCount.value?.plus(1) ?: 0)
    }

    fun addChild() {
        _childrenCount.postValue(_childrenCount.value?.plus(1) ?: 0)
    }

    fun addInfant() {
        _infantsCount.postValue(_infantsCount.value?.plus(1) ?: 0)
    }

    fun addPet() {
        _petsCount.postValue(_petsCount.value?.plus(1) ?: 0)
    }

    fun removeAdult() {
        _adultsCount.postValue(_adultsCount.value?.minus(1) ?: 0)
    }

    fun removeChild() {
        _childrenCount.postValue(_childrenCount.value?.minus(1) ?: 0)
    }

    fun removeInfant() {
        _infantsCount.postValue(_infantsCount.value?.minus(1) ?: 0)
    }

    fun removePet() {
        _petsCount.postValue(_petsCount.value?.minus(1) ?: 0)
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
        var sum = 0;
        guestsCount.forEach { if (it != null) sum += it }

        return sum;
    }


    fun hasSearchQuery(): Boolean {
        return _searchQuery.value != null && _searchQuery.value?.isNotBlank() ?: false
    }

    fun getSearchQueryOrElseEmptyStrings(): String {
        return if (searchQuery.value == null)
            ""
        else searchQuery.value.toString()
    }

}