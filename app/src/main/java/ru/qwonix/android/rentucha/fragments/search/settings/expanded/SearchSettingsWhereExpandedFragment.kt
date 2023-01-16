package ru.qwonix.android.rentucha.fragments.search.settings.expanded

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhereExpandedBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel
import ru.qwonix.android.rentucha.viewmodel.NavigationViewModel

class SearchSettingsWhereExpandedFragment :
    Fragment(R.layout.fragment_search_settings_where_expanded) {

    private lateinit var binding: FragmentSearchSettingsWhereExpandedBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()
    private val sharedNavigationViewModel: NavigationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchSettingsWhereExpandedBinding.inflate(inflater, container, false)
        binding.apply { viewModel = sharedSearchSettingsViewModel }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedNavigationViewModel.whereNavController = view.findNavController()

        view.findViewById<MaterialCardView>(R.id.where_expanded_search_bar)
            .setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_searchSettingsWhereExpandedFragment_to_searchFragment)
            }
    }
}