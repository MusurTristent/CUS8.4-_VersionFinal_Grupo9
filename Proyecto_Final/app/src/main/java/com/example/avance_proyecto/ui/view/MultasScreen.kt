package com.example.avance_proyecto.ui.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.avance_proyecto.R
import com.example.avance_proyecto.data.model.MultasEstadoItem
import com.example.avance_proyecto.navigation.AppScreen
import com.example.avance_proyecto.ui.theme.InformationCardContainer
import com.example.avance_proyecto.ui.theme.backgroundPrincipal
import com.example.avance_proyecto.ui.viewmodel.MultasEstadoViewModel
import java.lang.NumberFormatException

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MultasScreen(navController: NavController, body: String) {

    val multasEstadoViewModel: MultasEstadoViewModel = viewModel()

    val isLoading by multasEstadoViewModel.isLoading.collectAsState()

    val collectionTabs = listOf("") // Lista de opciones para el menú desplegable

    val dataBody: Int = try {
        body.toInt()
    }catch (e: NumberFormatException){
        0
    }
    var tabState by remember { mutableStateOf(dataBody) }
    val pagerState = rememberPagerState(dataBody)
    rememberCoroutineScope()
    LaunchedEffect(key1 = pagerState.currentPage){
        tabState = pagerState.currentPage
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column{
                SolcitudAppBar { navController.popBackStack() }
            }
        }

    ) {
        println(it)
        emptyList<MultasEstadoItem>()

            if(isLoading){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    CircularProgressIndicator(
                        color = backgroundPrincipal,
                        modifier = Modifier.size(50.dp).padding(it)
                    )
                }
            }else{
                HorizontalPager(
                    pageCount = collectionTabs.count(),
                    state = pagerState,
                    userScrollEnabled = true
                ) {tabIndex ->
                    when(tabIndex){
                        0 -> {
                            MultasList(
                                navController = navController,
                                contentPadding = it
                            )
                        }
                    }
                }
            }
    }
}

@Composable
fun SolcitudAppBar(
    onBackClick: () -> Unit
) {
    DefaultMultasAppBar(
        onBackClick = onBackClick
    )
}


@Composable
fun DefaultMultasAppBar(
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "CONDOSA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

        },
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        modifier = Modifier.background(backgroundPrincipal),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = backgroundPrincipal
        )
    )
}

@Composable
fun MultasList(
    navController: NavController,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {

    val heroes = listOf(
        MultasEstadoItem(
            id_casa_infraccion = 1,
            ap_paterno = "Quintana",
            ap_materno = "Ramirez",
            nombres = "Fabrizzio",
            codigo = "A22",
            importe = 250.00f,
            descripcion = "Maltratar, faltar el respeto, etc al personal de porteria,mantenim.,limpieza y/o Administ.",
            fecha_infraccion = "2023-06-07",
            periodo = "Semana"

        ),
        MultasEstadoItem(
            id_casa_infraccion = 2,
            ap_paterno = "Cespedes",
            ap_materno = "Zambrano",
            nombres = "Carlos",
            codigo = "A29",
            importe = 50.00f,
            descripcion = "Tránsito de mascotas en áreas comunes del Condominio sin el bosal",
            fecha_infraccion = "2023-06-07",
            periodo = "Dia"
        ),
        MultasEstadoItem(
            id_casa_infraccion = 3,
            ap_paterno = "Ojeda",
            ap_materno = "Zavaleta",
            nombres = "Kevin",
            codigo = "A37",
            importe = 85.00f,
            descripcion = "Bloquear total o parcialmente las vías de acceso de estacionamientos",
            fecha_infraccion = "2023-06-07",
            periodo = "Dia"
        ),
        MultasEstadoItem(
            id_casa_infraccion = 4,
            ap_paterno = "Perez",
            ap_materno = "Rodriguez",
            nombres = "Juan",
            codigo = "A37",
            importe = 85.00f,
            descripcion = "Bloquear total o parcialmente las vías de acceso de estacionamientos",
            fecha_infraccion = "2023-06-07",
            periodo = "Semana"
        ),
        MultasEstadoItem(
            id_casa_infraccion = 5,
            ap_paterno = "Saavedra",
            ap_materno = "Jimenez",
            nombres = "Luis",
            codigo = "B21",
            importe = 300.00f,
            descripcion = "Modificar las áreas de las estructuras originalmente entregadas por el constructor.",
            fecha_infraccion = "2023-06-07",
            periodo = "Semana"
        )
    )

    Box(
        modifier = modifier
            .padding(contentPadding)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo_condosa),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        LazyColumn {
            itemsIndexed(heroes) { index, hero ->
                MultasListItem(
                    hero = hero,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clickable { navController.navigate(route = AppScreen.informationScreen.route)}
                )

            }
        }
    }
}

@Composable
fun MultasListItem(
    hero: MultasEstadoItem,
    modifier: Modifier = Modifier
) {

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(InformationCardContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${hero.ap_paterno} ${hero.ap_materno}",
                    color = Color(0xFF9FFFFF),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 16.sp,
                )
                Text(
                    text = hero.nombres,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFF9FFFFF),
                    fontSize = 16.sp,
                )
                Text(
                    text = hero.fecha_infraccion,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Text(
                    text = "Importe: S/${hero.importe}",
                    textAlign = TextAlign.End,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red
                )
            }
        }
    }
}