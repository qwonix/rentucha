package ru.qwonix.android.rentucha.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.PopupMapApartmentBinding
import ru.qwonix.android.rentucha.entity.Apartment

class PopupMapApartment(
    private val apartment: Apartment
) : Fragment(R.layout.popup_map_apartment) {
    private lateinit var binding: PopupMapApartmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            PopupMapApartmentBinding.inflate(inflater, container, false)
        binding.apartment = apartment
        binding.fragment = this

        return binding.root
    }

    fun close() {
        parentFragmentManager.commit {
            remove(this@PopupMapApartment)
        }
    }
}