package com.khue.todoapp.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.khue.todoapp.ui.screens.task.TaskScreen
import com.khue.todoapp.util.Action
import com.khue.todoapp.util.Constants
import com.khue.todoapp.util.Constants.TASK_ARGUMENT_KEY
import com.khue.todoapp.viewmodels.SharedViewModel

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    composable(
        route = Constants.TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        // Đù má nó chạy nhiều lần luôn ạ
        // mặc dù biết nó chạy nhiều lần do nó thay đổi state nhưng vẫn khó hiểu vlvlvlvlv
        println("Running block")
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedViewModel.getSelectedTask(taskId = taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            println("Update value")
            println(selectedTask)
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskField(selectedTask)
            }
        }

        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen,
            sharedViewModel = sharedViewModel
        )
    }
}