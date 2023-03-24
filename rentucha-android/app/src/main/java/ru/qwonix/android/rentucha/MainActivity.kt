package ru.qwonix.android.rentucha

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yandex.mapkit.MapKitFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment

        findViewById<BottomNavigationView>(R.id.bottom_navigation_view_main).setupWithNavController(
            navHostFragment.navController
        )

        MapKitFactory.setApiKey(BuildConfig.YANDEX_MAPKIT_KEY)
        MapKitFactory.initialize(this)
    }
}