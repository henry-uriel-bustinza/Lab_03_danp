package com.danp.lab02.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.danp.lab02.R


private val messagesMatr: List<MyMessage> = listOf(
    MyMessage("Curso 01","Matriculado(s) 5 alumnos"),
    MyMessage("Curso 02", "Matriculado(s) 10 alumnos"),
    MyMessage("Curso 03","Matriculado(s) 2 alumnos"),
    MyMessage("Curso 04","Matriculado(s) 8 alumnos"),
    MyMessage("Curso 05","Matriculado(s) 3 alumnos"),
)


@Composable
fun SegundaVentana(navController: NavController, text: String?){
    var color_designado = Color(0xFFE01404)
    if(text == "cursos") {
        color_designado = Color(0xFFFFEB3B)
    }

    Scaffold(topBar = {
        TopAppBar(backgroundColor = color_designado) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Elija sus cursos")

        }
    }) {
        if(text == "Matriculas") {
            ListaMatr(navController, text, messagesMatr)
        }
    }
}

@Composable
fun ListaMatr(navController: NavController, text: String?, messages: List<MyMessage>) {
    LazyColumn {
        items(messages) { message->
            ContenidoMatr(navController = navController, text = text, message = message)
        }
    }
}

data class MyMessage(val title: String, val body: String)

@Composable
fun ContenidoMatr(navController: NavController, text: String?, message: MyMessage) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Image(
            painter = painterResource(R.drawable.cursos),
            contentDescription = "numero de alumnos 5",
            modifier = Modifier
                .size(100.dp)
        )

        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = message.title,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun SegundoContenido(navController: NavController, text: String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("")
        text?.let {
            Text(it)
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text ("")
        }
    }
}
