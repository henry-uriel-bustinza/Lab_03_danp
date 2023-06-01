package com.danp.lab02.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.danp.lab02.navigation.AppScreens
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.danp.lab02.R


@Composable
fun PrimeraVentana(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color(0xFFE01404)) {
            Text(text = "Sistema de matriculas")
        }
    }) {
        Contenido(navController)
    }
}

@Composable
fun Contenido(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/cursos")
            },  shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors(backgroundColor = Color(0xFFA36E20))) {
                Image(
                    painter = painterResource(R.drawable.matricula),
                    contentDescription = "cursos",
                    modifier = Modifier.size(170.dp)
                )
            }

            Spacer(Modifier.size(75.dp))

            Button(onClick = {
                navController.navigate(route = AppScreens.SegundaVentana.route + "/Matriculas")
            }, shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.textButtonColors(backgroundColor = Color(0xFFA36E20),
                    contentColor = Color(0xFF000000))
            ) {
                Text ("Matricularse")
            }

        }
    }
}

