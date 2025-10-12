package com.example.weatherkmp.location_finder

import android.Manifest
import android.content.Context
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.example.weatherkmp.location.Location
import com.example.weatherkmp.location.LocationController

 class LocationControllerImpl(private val context: Context) : LocationController {

    override suspend fun getCurrentLocation(): Location? {
        val lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != android.content.pm.PackageManager.PERMISSION_GRANTED
        ) {
            // Request permission from Activity before calling this
            return null
        }

        val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            ?: lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        return location?.let { Location(it.latitude, it.longitude) }
    }
}
