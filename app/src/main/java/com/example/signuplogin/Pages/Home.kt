package com.example.signuplogin.Pages

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.signuplogin.AuthState
import com.example.signuplogin.AuthViewMidel

@Composable
fun Home(modifier: Modifier = Modifier, navController: NavController, authViewMidel: AuthViewMidel) {


    val authState = authViewMidel.authState.observeAsState()
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.UnAuthenticated -> navController.navigate("login")
            else -> Unit

        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Home Page",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = {
            authViewMidel.signout()
        }) {
            Text(text = "Sign out")
        }
    }
}