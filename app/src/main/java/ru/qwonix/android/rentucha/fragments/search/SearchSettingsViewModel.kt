package ru.qwonix.android.rentucha.fragments.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchSettingsViewModel : ViewModel() {
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    fun setSearchQuery(searchQuery: String) {
        _searchQuery.postValue(searchQuery)
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