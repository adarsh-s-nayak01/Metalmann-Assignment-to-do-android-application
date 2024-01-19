package com.adarsh.mvvmtodoapp

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adarsh.mvvmtodoapp.ui.add_edit_todo.AddEditTodoScreen
import com.adarsh.mvvmtodoapp.ui.theme.MVVMTodoAppTheme
import com.adarsh.mvvmtodoapp.ui.todo_list.TodoListScreen
import com.adarsh.mvvmtodoapp.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTodoAppTheme {
                val navController = rememberNavController()
                // Scaffold is a high-level component that provides a top app bar and other common UI elements
                Scaffold(
                    topBar = {
                        TopAppBar(
                            modifier = Modifier,
                            title = {
                                Text(
                                    text = "Get It Done : A to-do app",
                                    style = MaterialTheme.typography.h6.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    ),
                                    fontFamily = FontFamily.SansSerif
                                )
                            }
                        )
                    }
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.TODO_LIST
                    ) {
                        //composable to display to list
                        composable(Routes.TODO_LIST) {
                            TodoListScreen(
                                onNavigate = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                        //composable to add a new task to the to-do list
                        composable(
                            route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                            arguments = listOf(
                                navArgument(name = "todoId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            AddEditTodoScreen(onPopBackStack = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}