package ru.qwonix.android.rentucha.fragments.search

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchBottomSheetBinding


class BottomSearchSheetFragment : Fragment(R.layout.fragment_search_bottom_sheet) {
    private lateinit var binding: FragmentSearchBottomSheetBinding
    private val sharedSearchSettingsViewModel: SearchSettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentSearchBottomSheetBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apartmentsAdapter = ApartmentsAdapter()
        sharedSearchSettingsViewModel.apartments.observe(viewLifecycleOwner) {
            apartmentsAdapter.apartments = it
        }

        binding.recyclerSearchApartments.apply {
            adapter = apartmentsAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    outRect.bottom = 100
                }
            })
        }
    }

}