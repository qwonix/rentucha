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
                           }

            var bottomNavigationViewY: Float = -1F;
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // FIXME: get global y location
                if (bottomNavigationViewY == -1F) {
                    bottomNavigationViewY = bottomNavigationView.y;
                }
                bottomNavigationView.animate()
                    .y(bottomNavigationViewY + bottomNavigationView.height * (1 - slideOffset))
                    .setDuration(0).start()
            }
        })

    }
}