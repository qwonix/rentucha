package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhoBinding
import ru.qwonix.android.rentucha.viewmodel.NavigationViewModel
import ru.qwonix.android.rentucha.viewmodel.SearchSettingsViewModel

class SearchSettingsWhoFragment : Fragment(R.layout.fragment_search_settings_who) {
    private lateinit var binding: FragmentSearchSettingsWhoBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()
    private val sharedNavigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsWhoBinding.inflate(inflater, container, false)
        binding.apply { viewModel = sharedSearchSettingsViewModel }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedNavigationViewModel.whoNavController = view.findNavController()

        binding.cardWhoSearchSetting.setOnClickListener {
            sharedNavigationViewModel.whoNavController
                .navigate(R.id.action_searchSettingsWhoFragment_to_searchSettingsWhoExpandedFragment)

            sharedNavigationViewModel.whereNavController.navigate(R.id.searchSettingsWhereFragment)
            sharedNavigationViewModel.whenNavController.navigate(R.id.searchSettingsWhenFragment)
        }

    }
}