package com.example.contactosjpc.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactosjpc.R
import com.example.contactosjpc.data.Contacto

@Composable
fun ContactRow(contacto: Contacto) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Foto contacto",
                Modifier.height(100.dp)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                Text(
                    text = contacto.name,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = contacto.phoneNumber,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
