package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhenBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel

class SearchSettingsWhenFragment : Fragment(R.layout.fragment_search_settings_when) {
    private lateinit var binding: FragmentSearchSettingsWhenBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()

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

        view.findViewById<MaterialCardView>(R.id.card_when_search_setting).setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_searchSettingsWhenFragment_to_searchSettingsWhenExpandedFragment)
        }
    }
}