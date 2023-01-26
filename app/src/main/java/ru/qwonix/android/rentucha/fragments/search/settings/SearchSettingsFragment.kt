package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel
import ru.qwonix.android.rentucha.viewmodel.NavigationViewModel

class SearchSettingsFragment : Fragment(R.layout.fragment_search_settings) {
    lateinit var binding: FragmentSearchSettingsBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()
    private val sharedNavigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSearchSettingsClear.setOnClickListener {
            sharedNavigationViewModel.whereNavController.navigate(R.id.searchSettingsWhereExpandedFragment)
            sharedNavigationViewModel.whenNavController.navigate(R.id.searchSettingsWhenFragment)
            sharedNavigationViewModel.whoNavController.navigate(R.id.searchSettingsWhoFragment)

            sharedSearchSettingsViewModel.clearSettings()
        }

        val closeSearchSettings: (v: View) -> Unit = {
            findNavController().navigate(R.id.action_searchSettingsFragment_to_mapFragment)
            val bottomNavigationView =
                view.rootView.findViewById<BottomNavigationView>(R.id.bottom_navigation_view_main)
            bottomNavigationView.animate()
                .yBy(-bottomNavigationView.height.toFloat())
                .setDuration(300).start()
        }

        binding.buttonSearchSettingsSearch.setOnClickListener(closeSearchSettings)
        binding.buttonSearchSettingsClose.setOnClickListener(closeSearchSettings)
    }
}