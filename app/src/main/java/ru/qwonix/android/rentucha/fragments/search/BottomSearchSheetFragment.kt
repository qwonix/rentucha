package ru.qwonix.android.rentucha.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.FragmentSearchBottomSheetBinding
import ru.qwonix.android.rentucha.entity.Apartment

class BottomSearchSheetFragment : Fragment(R.layout.fragment_search_bottom_sheet) {
    private lateinit var binding: FragmentSearchBottomSheetBinding

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

        val list = listOf<Apartment>(
            Apartment(
                "Россия",
                "Санкт-Петербург",
                4234.21,
                "https://i.imgur.com/8cUWZ9j.jpeg"
            ), Apartment(
                "Россия",
                "Санкт-Петербург",
                2342.54,
                "https://i.imgur.com/udaZzAd.jpeg"
            )
        )
        val adapter = ApartmentsAdapter(list)

        binding.recyclerSearchApartments.adapter = adapter
        binding.recyclerSearchApartments.layoutManager = LinearLayoutManager(context)
    }

}