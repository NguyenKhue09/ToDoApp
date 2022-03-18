package com.khue.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.primarySurface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.khue.todoapp.navigation.SetupNavigation
import com.khue.todoapp.ui.theme.ToDoAppTheme
import com.khue.todoapp.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                Surface(
                    color = MaterialTheme.colors.primarySurface,
                ) {
                    navController = rememberNavController()
                    SetupNavigation(
                        navController = navController,
                        sharedViewModel = sharedViewModel
                    )
                }
            }
        }
    }
}
