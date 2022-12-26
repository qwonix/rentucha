package ru.qwonix.android.rentucha

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView);
        val containerBottomSheet = findViewById<FrameLayout>(R.id.containerBottomSheet);
        val bottomSheetBehavior = BottomSheetBehavior.from(containerBottomSheet);

//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED;
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN;
//        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED;

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (BottomSheetBehavior.STATE_HALF_EXPANDED == newState || BottomSheetBehavior.STATE_EXPANDED == newState) {
                    bottomNavigationView.animate().scaleX(1F).scaleY(1F).setDuration(300).start();
                } else if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
                    bottomNavigationView.animate().scaleX(0F).scaleY(0F).setDuration(300).start();
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//                println(slideOffset)
//                bottomNavigationView.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset)
//                    .setDuration(0).start()
            }
        })

    }
}