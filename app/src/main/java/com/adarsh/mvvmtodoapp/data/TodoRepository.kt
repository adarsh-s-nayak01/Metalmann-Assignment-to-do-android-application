package com.adarsh.mvvmtodoapp.data

import kotlinx.coroutines.flow.Flow
//ToDoRepository’ interface as a single source of truth for To-Do data.
interface TodoRepository {

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodoById(id: Int): Todo?

    fun getTodos(): Flow<List<Todo>>
}