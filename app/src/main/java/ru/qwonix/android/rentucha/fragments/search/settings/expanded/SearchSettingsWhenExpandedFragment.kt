package ru.qwonix.android.rentucha.fragments.search.settings.expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhenExpandedBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel
import ru.qwonix.android.rentucha.viewmodel.NavigationViewModel

class SearchSettingsWhenExpandedFragment :
    Fragment(R.layout.fragment_search_settings_when_expanded) {

    private lateinit var binding: FragmentSearchSettingsWhenExpandedBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()
    private val sharedNavigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsWhenExpandedBinding.inflate(inflater, container, false)
        binding.apply { viewModel = sharedSearchSettingsViewModel }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonWhenSettingNext.setOnClickListener {
            sharedNavigationViewModel.whenNavController.navigate(R.id.action_searchSettingsWhenExpandedFragment_to_searchSettingsWhenFragment)
            sharedNavigationViewModel.whoNavController.navigate(R.id.action_searchSettingsWhoFragment_to_searchSettingsWhoExpandedFragment)
        }
        binding.buttonWhenSettingSkip.setOnClickListener {
            sharedNavigationViewModel.whenNavController.navigate(R.id.action_searchSettingsWhenExpandedFragment_to_searchSettingsWhenFragment)
            sharedNavigationViewModel.whoNavController.navigate(R.id.action_searchSettingsWhoFragment_to_searchSettingsWhoExpandedFragment)
        }
    }
}