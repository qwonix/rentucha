package ru.qwonix.android.rentucha.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.card.MaterialCardView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentMapBinding


class MapFragment : Fragment(R.layout.fragment_map) {
    private lateinit var binding: FragmentMapBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentMapBinding.inflate(inflater, container, false)
        binding.apply {
            viewModel = sharedSearchSettingsViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        // Перемещение камеры в центр Санкт-Петербурга.
        binding.mapview.map.move(
            CameraPosition(
                Point(59.945933, 30.320045), 14.0f, 0.0f, 0.0f
            )
        );

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView =
            view.rootView.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.containerBottomSheet)

//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN;
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED;

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED)
                    binding.mapview.map.isScrollGesturesEnabled = false
                if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                    binding.mapview.map.isScrollGesturesEnabled = true
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
            findNavController().navigate(R.id.action_mapFragment_to_searchSettingsFragment)
            bottomNavigationView.animate()
                .yBy(bottomNavigationView.height.toFloat())
                .setDuration(300).start()
        }
    }

    override fun onStop() {
        super.onStop()
        binding.mapview.onStop();
        MapKitFactory.getInstance().onStop();
    }

    override fun onStart() {
        super.onStart()
        binding.mapview.onStart();
        MapKitFactory.getInstance().onStart();
    }
}