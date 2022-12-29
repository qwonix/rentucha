package ru.qwonix.android.rentucha.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.card.MaterialCardView
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.fragments.search.settings.SearchSettingsFragment

class SearchFragment : Fragment(R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView =
            view.rootView.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val containerBottomSheet = view.findViewById<FrameLayout>(R.id.containerBottomSheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(containerBottomSheet)

//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN;
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED;

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }

            var bottomNavigationViewY: Float = -1F
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // FIXME: get global y location
                if (bottomNavigationViewY == -1F) {
                    bottomNavigationViewY = bottomNavigationView.y
                }
                bottomNavigationView.animate()
                    .y(bottomNavigationViewY + bottomNavigationView.height * (1 - slideOffset))
                    .setDuration(0).start()
            }
        })

        val searchBarCardView = view.findViewById<MaterialCardView>(R.id.search_bar)
        searchBarCardView.setOnClickListener {
            println("on searchBarCardView click")

            val newInstance = SearchSettingsFragment()
            parentFragmentManager.beginTransaction()
                .add(R.id.mainFragmentContainer, newInstance)
                .show(newInstance)
                .commit()
        }

        val searchBarFiltersCardView = view.findViewById<MaterialCardView>(R.id.search_bar_filters)
        searchBarFiltersCardView.setOnClickListener { println("on searchBarFilters click") }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }
}