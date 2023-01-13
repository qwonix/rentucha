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
import ru.qwonix.android.rentucha.databinding.FragmentSearchSettingsWhoBinding
import ru.qwonix.android.rentucha.fragments.search.SearchSettingsViewModel

class SearchSettingsWhoFragment : Fragment(R.layout.fragment_search_settings_who) {

    private lateinit var binding: FragmentSearchSettingsWhoBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()

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

        view.findViewById<MaterialCardView>(R.id.card_who_search_setting).setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_searchSettingsWhoFragment_to_searchSettingsWhoExpandedFragment)
        }

    }
}