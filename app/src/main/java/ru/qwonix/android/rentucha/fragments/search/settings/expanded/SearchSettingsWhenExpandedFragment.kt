package ru.qwonix.android.rentucha.fragments.search.settings.expanded

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R

class SearchSettingsWhenExpandedFragment :
    Fragment(R.layout.fragment_search_settings_when_expanded) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialCardView>(R.id.when_expanded_search_bar)
            .setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_searchSettingsWhenExpandedFragment_to_searchSettingsWhenFragment)
            }
    }
}