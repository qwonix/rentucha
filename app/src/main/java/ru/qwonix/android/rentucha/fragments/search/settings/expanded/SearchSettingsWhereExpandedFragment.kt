package ru.qwonix.android.rentucha.fragments.search.settings.expanded

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R

class SearchSettingsWhereExpandedFragment :
    Fragment(R.layout.fragment_search_settings_where_expanded) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialCardView>(R.id.where_expanded_search_bar)
            .setOnClickListener {
                view.findNavController()
                    .navigate(R.id.action_searchSettingsWhereExpandedFragment_to_searchFragment)
            }
    }
}