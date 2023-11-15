package com.example.avance_proyecto.ui.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.avance_proyecto.data.MultasDefaultDataSource
import com.example.avance_proyecto.ui.theme.ButtonColorDefault
import com.example.avance_proyecto.ui.theme.ButtonColorRed
import com.example.avance_proyecto.ui.theme.TextWhite
import com.example.avance_proyecto.ui.theme.background2
import com.example.avance_proyecto.ui.theme.backgroundPrincipal

@Composable
fun RegisterScreen(
    navController: NavController
) {
    var lastNameValue by remember { mutableStateOf(TextFieldValue()) }
    var middleNameValue by remember { mutableStateOf(TextFieldValue()) }
    var firstNameValue by remember { mutableStateOf(TextFieldValue()) }
    var codeValue by remember { mutableStateOf(TextFieldValue()) }
    var amountValue by remember { mutableStateOf(TextFieldValue()) }
    var descriptionValue by remember { mutableStateOf(TextFieldValue()) }
    var dateValue by remember { mutableStateOf(TextFieldValue()) }
    var periodValue by remember { mutableStateOf(TextFieldValue()) }

    var showRegistrationMessage by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            RegistroAppBarInformation(
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .background(background2)
                .fillMaxSize()
        ) {
            items(1) {
                RegisterBox(
                    lastNameValue = lastNameValue,
                    onLastNameValueChange = { lastNameValue = it },
                    middleNameValue = middleNameValue,
                    onMiddleNameValueChange = { middleNameValue = it },
                    firstNameValue = firstNameValue,
                    onFirstNameValueChange = { firstNameValue = it },
                    codeValue = codeValue,
                    onCodeValueChange = { codeValue = it },
                    amountValue = amountValue,
                    onAmountValueChange = { amountValue = it },
                    descriptionValue = descriptionValue,
                    onDescriptionValueChange = { descriptionValue = it },
                    dateValue = dateValue,
                    onDateValueChange = { dateValue = it },
                    periodValue = periodValue,
                    onPeriodValueChange = { periodValue = it }
                )
                RegisterButtonSection(
                    "Registrar",
                    lastNameValue.text,
                    onRegistrationComplete = { showRegistrationMessage = true }
                )

                if (showRegistrationMessage) {
                    RegistrationMessage(
                        onAddAnother = {
                            showRegistrationMessage = false
                            // Clear the input fields
                            lastNameValue = TextFieldValue()
                            middleNameValue = TextFieldValue()
                            firstNameValue = TextFieldValue()
                            codeValue = TextFieldValue()
                            amountValue = TextFieldValue()
                            descriptionValue = TextFieldValue()
                            dateValue = TextFieldValue()
                            periodValue = TextFieldValue()
                        },
                        onBack = { navController.navigateUp() }
                    )
                }
            }
        }
    }
}

@Composable
fun RegisterBox(
    lastNameValue: TextFieldValue,
    onLastNameValueChange: (TextFieldValue) -> Unit,
    middleNameValue: TextFieldValue,
    onMiddleNameValueChange: (TextFieldValue) -> Unit,
    firstNameValue: TextFieldValue,
    onFirstNameValueChange: (TextFieldValue) -> Unit,
    codeValue: TextFieldValue,
    onCodeValueChange: (TextFieldValue) -> Unit,
    amountValue: TextFieldValue,
    onAmountValueChange: (TextFieldValue) -> Unit,
    descriptionValue: TextFieldValue,
    onDescriptionValueChange: (TextFieldValue) -> Unit,
    dateValue: TextFieldValue,
    onDateValueChange: (TextFieldValue) -> Unit,
    periodValue: TextFieldValue,
    onPeriodValueChange: (TextFieldValue) -> Unit
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp)
            .clip(MaterialTheme.shapes.small)
            .clickable { /* Optional: handle click */ }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Apellido Paterno
            TextField(
                value = lastNameValue,
                onValueChange = onLastNameValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Apellido Paterno") }
            )

            // Apellido Materno
            TextField(
                value = middleNameValue,
                onValueChange = onMiddleNameValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Apellido Materno") }
            )

            // Nombres
            TextField(
                value = firstNameValue,
                onValueChange = onFirstNameValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Nombres") }
            )

            // Código
            TextField(
                value = codeValue,
                onValueChange = onCodeValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Código") }
            )

            // Importe
            TextField(
                value = amountValue,
                onValueChange = onAmountValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Importe") }
            )

            // Descripción
            TextField(
                value = descriptionValue,
                onValueChange = onDescriptionValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Descripción") }
            )

            // Fecha de la infracción
            TextField(
                value = dateValue,
                onValueChange = onDateValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Fecha de la infracción") }
            )

            // Periodo
            TextField(
                value = periodValue,
                onValueChange = onPeriodValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .clip(MaterialTheme.shapes.medium.copy(
                        topStart = CornerSize(8.dp),
                        topEnd = CornerSize(8.dp),
                        bottomStart = CornerSize(8.dp),
                        bottomEnd = CornerSize(8.dp)
                    )),
                label = { Text("Periodo") }
            )
        }
    }
}

@Composable
fun RegistrationMessage(
    onAddAnother: () -> Unit,
    onBack: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Registrado exitosamente!", fontWeight = FontWeight.Bold, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onAddAnother) {
                    Text("Añadir otro registro")
                }

                Button(onClick = onBack) {
                    Text("Volver")
                }
            }
        }
    }
}


@Composable
fun RegisterButtonSection(
    buttonLabel: String,
    textToRegister: String,
    onRegistrationComplete: () -> Unit
) {
    LocalContext.current

    Column(
        modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                onRegistrationComplete()
            },
            colors = ButtonDefaults.buttonColors(
                ButtonColorDefault,
                Color.White
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = buttonLabel, color = TextWhite, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}


@Composable
fun RegistroAppBarInformation(
    navigateUp: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.background(backgroundPrincipal),
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Registrar Usuario",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = backgroundPrincipal
        ),
        navigationIcon = {
            IconButton(onClick = navigateUp) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        }
    )
}


@Preview
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}
