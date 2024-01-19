package com.adarsh.mvvmtodoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    val title: String,
    val description: String?,
    val isDone: Boolean,
    @PrimaryKey val id: Int? = null
)
//Defining an entity class named ‘ToDo’ with ‘id’ as the primary key,
//‘title’, ‘description’ which is optional, and ‘isCompleted’ fields.
// Here, description is made nullable because the user can choose to keep the description to be null but he can’t keep the title empty.
//id if not given is assigned by the room database itself, so it is also nullable
