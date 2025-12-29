package com.yakut.kepsee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val navController = rememberNavController()
            
            NavHost(
                navController = navController,
                startDestination = "login"
            ) {
                // Экран входа
                composable("login") {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("🚀 Kepsee Messenger", fontSize = 28.sp)
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Модуль 3: Авторизация", fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(48.dp))
                        
                        Button(onClick = { 
                            navController.navigate("main") 
                        }) {
                            Text("Войти (демо)")
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(onClick = { 
                            navController.navigate("register") 
                        }) {
                            Text("Регистрация")
                        }
                    }
                }
                
                // Экран регистрации
                composable("register") {
                    val username = remember { mutableStateOf("") }
                    
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("📝 Регистрация", fontSize = 24.sp)
                        Spacer(modifier = Modifier.height(48.dp))
                        
                        Button(onClick = { 
                            navController.navigate("main") {
                                popUpTo("login") { inclusive = true }
                            }
                        }) {
                            Text("Зарегистрироваться")
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(onClick = { 
                            navController.popBackStack() 
                        }) {
                            Text("Назад")
                        }
                    }
                }
                
                // Главный экран
                composable("main") {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("🏠 Главный экран", fontSize = 24.sp)
                        Spacer(modifier = Modifier.height(24.dp))
                        Text("Модуль 3 успешно реализован!", fontSize = 16.sp)
                        Spacer(modifier = Modifier.height(48.dp))
                        
                        Button(onClick = { 
                            navController.navigate("login") {
                                popUpTo(0) { inclusive = true }
                            }
                        }) {
                            Text("Выйти")
                        }
                    }
                }
            }
        }
    }
}
