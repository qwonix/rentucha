package ru.qwonix.android.rentucha.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class NavigationViewModel : ViewModel() {
    lateinit var whereNavController: NavController
    lateinit var whenNavController: NavController
    lateinit var whoNavController: NavController
}