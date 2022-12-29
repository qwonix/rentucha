package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ru.qwonix.android.rentucha.R


class SearchSettingsFragment : Fragment(R.layout.fragment_search_settings) {
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print("--------------")
        navController = findNavController()
        print(navController)
    }

}