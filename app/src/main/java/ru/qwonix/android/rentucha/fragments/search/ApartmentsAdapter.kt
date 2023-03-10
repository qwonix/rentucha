package ru.qwonix.android.rentucha.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.qwonix.android.rentucha.databinding.ItemSearchApartmentBinding
import ru.qwonix.android.rentucha.entity.Apartment

class ApartmentsAdapter : RecyclerView.Adapter<ApartmentsAdapter.ApartmentViewHolder>() {

    var apartments = listOf<Apartment>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var binding: ItemSearchApartmentBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApartmentViewHolder {
        binding =
            ItemSearchApartmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApartmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApartmentViewHolder, position: Int) {
        holder.bind(apartments[position])
    }

    override fun getItemCount(): Int = apartments.size

    class ApartmentViewHolder(
        private val binding: ItemSearchApartmentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(apartment: Apartment) {
            binding.apartment = apartment
        }
    }
}