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

@Composable
fun AddItem (navController: NavController){

    var txtFirstName by remember { mutableStateOf("") }
    var txtLastName by remember { mutableStateOf("") }
    var txtAge by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = txtFirstName,
            onValueChange = {
                txtFirstName = it
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
                val user = User(0,txtFirstName,txtLastName, txtAge.toInt())
                insertarDatos(context,user)
                Toast.makeText(context, user.firstName, Toast.LENGTH_SHORT).show()
                //navController.navigate(Screen.ListItems.route)
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