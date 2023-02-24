package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhenBinding
import ru.qwonix.android.rentucha.viewmodel.NavigationViewModel
import ru.qwonix.android.rentucha.viewmodel.SearchSettingsViewModel

class SearchSettingsWhenFragment : Fragment(R.layout.fragment_search_settings_when) {
    private lateinit var binding: FragmentSearchSettingsWhenBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()
    private val sharedNavigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsWhenBinding.inflate(inflater, container, false)
        binding.apply { viewModel = sharedSearchSettingsViewModel }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedNavigationViewModel.whenNavController = view.findNavController()

        binding.cardWhenSearchSetting.setOnClickListener {
            sharedNavigationViewModel.whenNavController
                .navigate(R.id.action_searchSettingsWhenFragment_to_searchSettingsWhenExpandedFragment)

            sharedNavigationViewModel.whereNavController.navigate(R.id.searchSettingsWhereFragment)
            sharedNavigationViewModel.whoNavController.navigate(R.id.searchSettingsWhoFragment)
        }
    }
}