package com.example.helloworldcompose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.helloworldcompose.data.UserDatabase

fun showNotifiacion (context: Context, msg : String){
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}

@Composable
fun ListItems (navController: NavController){
    val context = LocalContext.current;
    val db = UserDatabase.getDatabase(context)
    var usuarios = db.userDao().readAllData()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ){
            items(usuarios) { usuario ->
                Surface( modifier = Modifier.clickable { showNotifiacion(context,usuario.id.toString()) } ) {
                    Text(text = usuario.firstName, fontSize = 30.sp)
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(Screen.AddItem.route)
            },
            backgroundColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add,"")
        }
    }
}
