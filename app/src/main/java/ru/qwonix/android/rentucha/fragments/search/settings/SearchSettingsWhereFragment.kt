package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhereBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel
import ru.qwonix.android.rentucha.viewmodel.NavigationViewModel

class SearchSettingsWhereFragment : Fragment(R.layout.fragment_search_settings_where) {
    private lateinit var binding: FragmentSearchSettingsWhereBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()
    private val sharedNavigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsWhereBinding.inflate(inflater, container, false)
        binding.apply { viewModel = sharedSearchSettingsViewModel }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardWhereSearchSetting.setOnClickListener {
            sharedNavigationViewModel.whereNavController
                .navigate(R.id.action_searchSettingsWhereFragment_to_searchSettingsWhereExpandedFragment)

            sharedNavigationViewModel.whenNavController.navigate(R.id.searchSettingsWhenFragment)
            sharedNavigationViewModel.whoNavController.navigate(R.id.searchSettingsWhoFragment)
        }
    }
}