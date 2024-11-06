package com.learning.practice_nvvm_nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun appnavigation() {
    val navcnrtl = rememberNavController()
    val countviewmodel: CounterViewModel = viewModel()
    val setviewmodel: settingviewmodel = viewModel()

    NavHost(navController = navcnrtl, startDestination = "counter screen") {
        composable("counter screen") {
            val counterValue by countviewmodel.counter
            counterapp(
                navigatetosetting = {
                    navcnrtl.navigate("settings/$counterValue")  // Pass the counterValue to settings screen
                },
                viewmodel_object = countviewmodel
            )
        }
        composable("settings/{counterValue}") { backStackEntry ->
            // Retrieve the counter value from the navigation argument
            val counterValue = backStackEntry.arguments?.getString("counterValue")?.toInt() ?: 0

            setting(
                navigatetocounter = { navcnrtl.navigate("counter screen") },
                settviewmodelobject = setviewmodel,
                count = counterValue  // Use the retrieved counterValue here
            )
        }
    }
}