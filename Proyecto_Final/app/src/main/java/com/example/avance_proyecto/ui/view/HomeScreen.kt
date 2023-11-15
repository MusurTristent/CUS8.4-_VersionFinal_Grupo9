package com.example.avance_proyecto.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avance_proyecto.R
import com.example.avance_proyecto.navigation.AppScreen
import com.example.avance_proyecto.ui.theme.Avance_ProyectoTheme

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.fondo_condosa),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Content
        Box(
            modifier = Modifier
                .background(Color(0xFF085394))
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CONDOSA",
                fontSize = 40.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

            // Ajuste de posición para los botones
            Spacer(modifier = Modifier.height(8.dp)) // Reducir espacio entre el título y los botones

            // Botones
            BodyContentHome(navController)
        }
    }


@Composable
fun BodyContentHome(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = {
                navController.navigate(route = AppScreen.registerScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF085394),
                Color.White
            ),
            modifier = Modifier
                .padding(16.dp) // Añade espacio alrededor del botón
                .height(60.dp)   // Ajusta la altura del botón
                .width(260.dp)  // Ajusta la anchura del botón
        ) {
            Text(
                text = "Registrar Multas",
                fontSize = 18.sp // Ajusta el tamaño de la fuente
            )
        }
        Button(
            onClick = {
                navController.navigate(route = AppScreen.multasScreen.route + "/" + "0")
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF085394),
                Color.White
            ),
            modifier = Modifier
                .padding(26.dp) // Añade espacio alrededor del botón
                .height(60.dp)   // Ajusta la altura del botón
                .width(260.dp)  // Ajusta la anchura del botón
        ) {
            Text(
                text = "Ver Multas",
                fontSize = 18.sp // Ajusta el tamaño de la fuente
            )
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    Avance_ProyectoTheme(darkTheme = false) {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}