package com.khue.todoapp.data.model

import androidx.compose.ui.graphics.Color
import com.khue.todoapp.ui.theme.HighPriorityColor
import com.khue.todoapp.ui.theme.LowPriorityColor
import com.khue.todoapp.ui.theme.MediumPriorityColor
import com.khue.todoapp.ui.theme.NonePriorityColor


enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}