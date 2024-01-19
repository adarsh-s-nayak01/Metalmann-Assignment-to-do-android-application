package com.adarsh.mvvmtodoapp.ui.todo_list

import com.adarsh.mvvmtodoapp.data.Todo

//Sealed class representing different events that can occur on the Todo list screen.
sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}
