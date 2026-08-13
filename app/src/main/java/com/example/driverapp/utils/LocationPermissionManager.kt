package com.example.driverapp.utils.LocationPermissionManager
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.content.ContextCompat
import android.provider.Settings

object LocationPermissionManager {

    fun hasLocationPermission(
        context: Context
    ): Boolean {

        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun isGpsEnabled(
        context: Context
    ): Boolean {

        val locationManager =
            context.getSystemService(
                Context.LOCATION_SERVICE
            ) as LocationManager

        return locationManager.isProviderEnabled(
            LocationManager.GPS_PROVIDER
        )
    }

    fun openLocationSettings(
        context: Context
    ) {

        val intent = Intent(
            Settings.ACTION_LOCATION_SOURCE_SETTINGS
        )

        context.startActivity(intent)
    }

}

//----------Granting Permission--------------------------------

//Understanding->
//ContextCompat.checkSelfPermission(
//->
//Android se pooch rahi hai:
//
//"Is app ke paas ye permission hai?"
//Ye:
//
//context
//
//Current app ka context hai.
//
//Jaise:
//
//Driver App
//
//Ye:
//
//Manifest.permission.ACCESS_FINE_LOCATION
//
//Permission ka naam hai.
//
//Matlab Android se pooch rahe ho:
//
//"Kya Driver App ke paas
//ACCESS_FINE_LOCATION permission hai?"

//Android jawab deta hai:
//
//PackageManager.PERMISSION_GRANTED
//
//ya
//
//PackageManager.PERMISSION_DENIED


//Usage:->
//if(
//LocationPermissionManager.hasLocationPermission(
//context
//)
//){
//    // location le lo
//}else{
//    // permission mango
//}


//permission mangne ka tarika ->


//val locationPermissionLauncher =
//    rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.RequestPermission()
//    ) { isGranted ->
//
//        if (isGranted) {
//            println("Permission Granted")
//        } else {
//            println("Permission Denied")
//        }
//    }

//Button(
//onClick = {
//    locationPermissionLauncher.launch(
//        Manifest.permission.ACCESS_FINE_LOCATION
//    )
//}
//)

//------------------------GPS--------------------------------

//Samajh
//
//Ye line:
//
//val locationManager =
//    context.getSystemService(
//        Context.LOCATION_SERVICE
//    ) as LocationManager
//
//Android se Location Service nikal rahi hai.
//
//Jaise:
//
//Bluetooth Service
//Wifi Service
//Location Service
//
//Fir:
//
//locationManager.isProviderEnabled(
//LocationManager.GPS_PROVIDER
//)
//
//Android se pooch rahe ho:
//
//GPS ON hai?
//
//Result:
//
//GPS ON
//↓
//true
//GPS OFF
//↓
//false


//Usage->
//if(
//LocationPermissionManager.isGpsEnabled(
//context
//)
//){
//    println("GPS ON")
//}else{
//    println("GPS OFF")
//}

//---------openLocationSettings-------------------

//if (
//LocationPermissionManager.isGpsEnabled(context)
//) {
//    println("GPS ON")
//} else {
//
//    LocationPermissionManager.openLocationSettings(
//        context
//    )
//}