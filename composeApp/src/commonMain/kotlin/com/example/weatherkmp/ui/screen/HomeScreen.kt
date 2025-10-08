package com.example.weatherkmp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherkmp.data.data_object_model.WeatherDto
import com.example.weatherkmp.ui.component.ImageNormal
import com.example.weatherkmp.ui.component.LocationFieldWithIcon
import com.example.weatherkmp.ui.component.Spacer16DPH
import com.example.weatherkmp.ui.component.TextView16_W400
import com.example.weatherkmp.ui.component.TextView24_W500
import com.example.weatherkmp.ui.component.TextView68_W700
import com.example.weatherkmp.ui.component.gradientColor
import com.example.weatherkmp.ui.theme.white_color

@Composable
fun HomeScreen(){
    val latitude = remember {
        mutableStateOf("0")
    }

    val longitude = remember {
        mutableStateOf("0")
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = gradientColor()
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row {
                LocationFieldWithIcon(title = "Selected Location",
                    latitude = latitude,
                    longitude = longitude,
                    onLocationSelected = { lat, lng, isClicked ->


                    })
            }
            Spacer16DPH()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                WeatherData(WeatherDto(temp = 21.20, feelLike = 20.1,description = "Sunny", icon = ""))

            }
            Spacer16DPH()

            Button(onClick = {
               // navController.navigate(com.masum.weather.route.SearchScreen)
            }) {
                TextView16_W400(
                    value = "Search Location", color = white_color
                )
            }
        }
    }
}

@Composable
fun WeatherData( data: WeatherDto) {
    Row(
        horizontalArrangement = Arrangement.Center,

        ) {
     //   Icon(Icons.Default.LocationOn, contentDescription = "Icon", tint = white_color)
        TextView24_W500(
            value = "Dhaka Bangladesh",
            color = white_color
        )
    }
    Spacer16DPH()
    ImageNormal(data.icon ?: "")
    Spacer16DPH()
    TextView68_W700(
        value = "${data.temp ?: ""}°C", color = white_color
    )
    TextView24_W500(
        value = data.description ?: "", color = white_color
    )


}