package ru.qwonix.android.rentucha.fragments.search.settings.expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhoExpandedBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel

class SearchSettingsWhoExpandedFragment : Fragment(R.layout.fragment_search_settings_who_expanded) {
    private lateinit var binding: FragmentSearchSettingsWhoExpandedBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsWhoExpandedBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = sharedSearchSettingsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
}