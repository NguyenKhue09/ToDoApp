package com.khue.todoapp.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.khue.todoapp.ui.screens.splash.SplashScreen
import com.khue.todoapp.util.Constants

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {

    composable(
        route = Constants.SPLASH_SCREEN,
        exitTransition = {
            slideOutVertically(
                targetOffsetY = { fullHeight ->
                    -fullHeight
                },
                animationSpec = tween(300)
            )
        }
    ) {
        SplashScreen(
            navigateToListScreen = navigateToListScreen
        )
    }
}