package ru.qwonix.android.rentucha.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import ru.qwonix.android.rentucha.R
import ru.qwonix.android.rentucha.databinding.ItemSearchApartmentBinding

class ItemSearchApartment : Fragment(R.layout.item_search_apartment) {
    private lateinit var binding: ItemSearchApartmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            ItemSearchApartmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, imageUrl: String?) {
            Picasso.get().load(imageUrl).into(view)
        }
    }

}