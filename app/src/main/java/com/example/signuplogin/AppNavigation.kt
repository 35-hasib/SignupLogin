package com.example.signuplogin

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.signuplogin.Pages.Home
import com.example.signuplogin.Pages.Login
import com.example.signuplogin.Pages.Signup

@Composable
fun AppNavigation(modifier: Modifier = Modifier,authViewMidel: AuthViewMidel) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login"){
            Login(modifier,navController,authViewMidel)
        }
        composable("signup"){
            Signup(modifier,navController,authViewMidel)
        }
        composable("home"){
            Home(modifier,navController,authViewMidel)
        }
    })
}