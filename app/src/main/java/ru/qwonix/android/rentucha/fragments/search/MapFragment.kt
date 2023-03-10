package ru.qwonix.android.rentucha.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.runtime.ui_view.ViewProvider
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentMapBinding
import ru.qwonix.android.rentucha.databinding.PlacemarkMapApartmentBinding
import ru.qwonix.android.rentucha.entity.Apartment
import ru.qwonix.android.rentucha.viewmodel.SearchSettingsViewModel


class MapFragment : Fragment(R.layout.fragment_map) {

    private var placemarkTapListeners = ArrayList<MapObjectTapListener>()
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView =
            view.rootView.findViewById<BottomNavigationView>(R.id.bottom_navigation_view_main)
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.containerBottomSheetMain)

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED)
                    binding.mapviewMain.map.isScrollGesturesEnabled = false
                if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                    binding.mapviewMain.map.isScrollGesturesEnabled = true
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

        // FIXME: with BottomSheetBehavior.STATE_COLLAPSED goes under the interface
        binding.searchBar.setOnClickListener {
            findNavController().navigate(R.id.action_mapFragment_to_searchSettingsFragment)
            bottomNavigationView.animate()
                .yBy(bottomNavigationView.height.toFloat())
                .setDuration(300).start()
        }

        // Moving the camera to the center of St. Petersburg.
        binding.mapviewMain.map.move(
            CameraPosition(
                Point(59.945933, 30.320045), 14.0f, 0.0f, 0.0f
            )
        )

        sharedSearchSettingsViewModel.apartments.observeForever { addApartmentsToMap(it) }

        sharedSearchSettingsViewModel.requestApartments()
    }

    private fun addApartmentsToMap(apartments: List<Apartment>) {
        apartments.forEach { addApartmentToMap(it) }
    }

    private fun addApartmentToMap(apartment: Apartment) {
        val placemarkMapApartmentBinding =
            PlacemarkMapApartmentBinding.inflate(layoutInflater, null, true)

        placemarkMapApartmentBinding.apartment = apartment
        placemarkMapApartmentBinding.executePendingBindings()

        val placemarkTapListener = MapObjectTapListener { _, _ ->
            parentFragmentManager.commit {
                replace(
                    R.id.popup_map_fragment_container,
                    PopupMapApartment(apartment)
                )
            }
            false
        }

        binding.mapviewMain.map.mapObjects.addPlacemark(
            Point(apartment.latitude, apartment.longitude),
            ViewProvider(placemarkMapApartmentBinding.root)
        ).apply {
            userData = apartment
            addTapListener(placemarkTapListener)
        }

        placemarkTapListeners.add(placemarkTapListener)
    }

    override fun onStop() {
        super.onStop()
        binding.mapviewMain.onStop()
        MapKitFactory.getInstance().onStop()
    }

    override fun onStart() {
        super.onStart()
        binding.mapviewMain.onStart()
        MapKitFactory.getInstance().onStart()
    }
}