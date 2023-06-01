package com.danp.lab02.navigation

sealed class AppScreens(val route: String) {
    object PrimeraVentana: AppScreens("firs_screen")
    object SegundaVentana: AppScreens("second_screen")
}
