package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R

class SearchSettingsWhoFragment : Fragment(R.layout.fragment_search_settings_who) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialCardView>(R.id.card_who_search_setting).setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_searchSettingsWhoFragment_to_searchSettingsWhoExpandedFragment)
        }

    }
}