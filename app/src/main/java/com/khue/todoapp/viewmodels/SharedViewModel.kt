package com.khue.todoapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khue.todoapp.data.model.ToDoTask
import com.khue.todoapp.data.repositories.ToDoRepository
import com.khue.todoapp.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks =
        MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> = _allTasks


    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}