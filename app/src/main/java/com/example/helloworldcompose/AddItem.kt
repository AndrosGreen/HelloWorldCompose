package com.example.helloworldcompose

import android.app.Application
import android.content.Context
import android.service.autofill.UserData
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.helloworldcompose.data.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun AddItem (navController: NavController, viewModel: UserViewModel){

    var txtFirstName by remember { mutableStateOf("") }
    var txtLastName by remember { mutableStateOf("") }
    var txtAge by remember { mutableStateOf("") }
    val context = LocalContext.current

    val nombre by viewModel.nombre().observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nombre,
            onValueChange = {
                viewModel.cambiarNombre(it)
            },
            placeholder = { Text("First Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = txtLastName,
            onValueChange = {
                txtLastName = it
            },
            placeholder = { Text("Last Name") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = txtAge,
            onValueChange = {
                txtAge = it
            },
            placeholder = { Text("Age") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                val user = User( firstName = nombre, lastName = txtLastName, age = txtAge.toInt())
                insertarDatos(context,user)
                Toast.makeText(context, user.firstName , Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.ListItems.route)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Add Item")
        }
    }
}

fun insertarDatos (context: Context, user : User){
    val db = UserDatabase.getDatabase(context)
    db.userDao().addUser(user)
}

//@Composable
//@Preview
//fun PreviewAddItem (){
//    AddItem()
//}