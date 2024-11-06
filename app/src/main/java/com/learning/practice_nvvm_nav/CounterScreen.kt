package com.learning.practice_nvvm_nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// this the view portion of nvvm
// obects of view models are created and process for out put here



@Composable
fun counterapp(navigatetosetting:()->Unit,viewmodel_object: CounterViewModel){
    val counterValue by viewmodel_object.counter

        Row (
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ){
            IconButton(onClick = { navigatetosetting() }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings Icon",
                )
            }
        }
        Row(
            modifier = Modifier.padding(30.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            Text("Counter App",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }

        Row {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("counter : $counterValue")
                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { viewmodel_object.incrementCounter() }) {
                    Text("increment")
                }
                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { viewmodel_object.resetCounter() }) {
                    Text("reset")
                }

            }
        }

    }

@Preview(showBackground = true)
@Composable
fun counterapppreviw (){
    //counterapp();
}