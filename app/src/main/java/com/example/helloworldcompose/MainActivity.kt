package com.example.helloworldcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.TopAppBar
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.helloworldcompose.data.UserViewModel

class MainActivity : ComponentActivity() {

    var notas : List<String> = listOf<String>(
        "Pika Pika",
        "Squirtle",
        "Lugia",
        "Mankey",
        "Camerupt",
        "Seel",
        "Grotle",
        "Riolu",
        "Charmander",
        "Charizard",
        "Oddish",
        "Swampert",
        "Horsea",
        "Pika Pika",
        "Squirtle",
        "Lugia",
        "Mankey",
        "Camerupt",
        "Seel",
        "Grotle",
        "Riolu",
    );

    fun click_poke(s : String){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel: UserViewModel by viewModels()

            Column {
                TopAppBar(title = {
                    Text(text = stringResource(id = R.string.app_name))
                } )
                Navigation(viewModel = viewModel)

            }



            //ListaNotas(listaNotas = notas) {
            //    click_poke("hola $it")
            //}

        }
    }

    @Composable
    private fun ListaNotas(listaNotas: List<String>, showNotifiacion: (String)->Unit){
        LazyColumn(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ){
            items(listaNotas) { note ->
                Surface( modifier = Modifier.clickable { showNotifiacion(note) } ) {
                    Nota(note)
                }
            }
        }
    }

    @Composable
    private fun Nota( msg : String){
        Text(text = msg, fontSize = 30.sp)
    }

    @Composable
    private fun PersonaData(name: String){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
               painter = painterResource(id = R.drawable.poli),
               contentDescription = "poke poke",
               modifier = Modifier
                   .height(200.dp)
                   .width(200.dp)
            )

            Text(text = "Mi nombre es $name")
            Text(text = "Soy programador")
            Text(text = "Batman the dark knight")
        }
    }

    @Preview
    @Composable
    fun PreviewPersonalData(){
        PersonaData(name = "Andros")
    }
    
}

