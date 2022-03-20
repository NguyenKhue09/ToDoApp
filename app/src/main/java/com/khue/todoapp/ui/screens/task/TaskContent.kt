package com.khue.todoapp.ui.screens.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.khue.todoapp.R
import com.khue.todoapp.components.PriorityDropDown
import com.khue.todoapp.data.model.Priority
import com.khue.todoapp.ui.theme.LARGE_PADDING

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = {
                Text(
                    text = stringResource(R.string.title)
                )
            }
        )
        PriorityDropDown(
            priority = priority,
            onPrioritySelected = {
                onPrioritySelected(it)
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = {
                Text(
                    text = stringResource(R.string.description)
                )
            }
        )
    }
}