package ru.qwonix.android.rentucha.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchSettingsViewModel : ViewModel() {
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    private val _adultsCount = MutableLiveData<Int>(1)
    val adultsCount: LiveData<Int> = _adultsCount

    private val _childrenCount = MutableLiveData<Int>(0)
    val childrenCount: LiveData<Int> = _childrenCount

    private val _infantsCount = MutableLiveData<Int>(0)
    val infantsCount: LiveData<Int> = _infantsCount

    private val _petsCount = MutableLiveData<Int>(0)
    val petsCount: LiveData<Int> = _petsCount

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


    fun setSearchQuery(searchQuery: String) {
        _searchQuery.postValue(searchQuery)
    }

    fun getSearchBarSettingsDescriptionText(): String {
        var text = "";
        if (_searchQuery.value != null) {
            text += _searchQuery.value + " · "
        }

        text += getGuestsCount().toString() + " guests"

        return text;
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
        return searchQuery.value != null
    }

    fun getSearchQueryOrElseEmptyStrings(): String {
        return if (searchQuery.value == null)
            ""
        else searchQuery.value.toString()
    }

}