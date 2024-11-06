package com.learning.practice_nvvm_nav

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun setting(count: Int, navigatetocounter: () -> Unit, settviewmodelobject: settingviewmodel) {
    val selectindex by settviewmodelobject.selectedindex
    val coloptions = settviewmodelobject.coloptn


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Counter App",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = coloptions[selectindex]
            )


            IconButton(onClick = { navigatetocounter() }) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "close icon"
                )
            }
        }
        Row {
            Text("Counter score = $count")
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row {
            coloptions.forEachIndexed { index, color ->
                Box(modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clickable { settviewmodelobject.uodatecolor(index) }
                    .background(
                        if (selectindex == index) color else color.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(
                        width = if (selectindex == index) 3.dp else 0.dp,
                        color = if (selectindex == index) Color.Black.copy(alpha = 0.5f) else Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )
                ) {
                }
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun settingpreviw() {
    //setting()
}