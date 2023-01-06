package ru.qwonix.android.rentucha.fragments.search.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R

class SearchSettingsFragment : Fragment(R.layout.fragment_search_settings) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialCardView>(R.id.search_settings_close_btn).setOnClickListener {
            findNavController().navigate(R.id.action_searchSettingsFragment_to_searchFragment)
            val bottomNavigationView =
                view.rootView.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomNavigationView.animate()
                .yBy(-bottomNavigationView.height.toFloat())
                .setDuration(300).start()
        }
    }
}