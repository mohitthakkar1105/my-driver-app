package com.example.driverapp.utils
import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

object LocationService {

    private var locationCallback: LocationCallback? = null

    fun getLocationClient(
        context: Context
    ): FusedLocationProviderClient {

        return LocationServices.getFusedLocationProviderClient(
            context
        )
    }

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(
        context: Context,
        onLocationReceived: (Double, Double) -> Unit
    ) {

        val client = getLocationClient(context)

        client.lastLocation.addOnSuccessListener { location ->

            if (location != null) {
                onLocationReceived(
                    location.latitude,
                    location.longitude
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun requestLocationUpdates(
        context: Context,
        onLocationReceived: (Double, Double) -> Unit
    ) {

        val client = getLocationClient(context)

        val locationRequest =
            LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY,
                3000L
            )
                .setMinUpdateIntervalMillis(2000L)
                .build()

        locationCallback =
            object : LocationCallback() {

                override fun onLocationResult(
                    result: LocationResult
                ) {

                    val location =
                        result.lastLocation

                    location?.let {

                        onLocationReceived(
                            it.latitude,
                            it.longitude
                        )
                    }
                }
            }

        client.requestLocationUpdates(
            locationRequest,
            locationCallback!!,
            Looper.getMainLooper()
        )
    }

    fun stopLocationUpdates(
        context: Context
    ) {

        val client = getLocationClient(context)

        locationCallback?.let {

            client.removeLocationUpdates(
                it
            )
        }
    }

}

//
//Step 1
//val geocoder = Geocoder(
//    context,
//    Locale.getDefault()
//)
//
//Yani:
//
//Address Finder Machine bana do


//Step 2
//val addresses =
//    geocoder.getFromLocation(
//        lat,
//        lng,
//        1
//    )
//
//Yani:
//
//21.1702
//72.8311
//
//iska address nikal ke do

//
//Android return karta hai:
//
//[
//Address(...)
//]
//
//Ek list milti hai.
//
//Isliye:
//
//addresses
//
//ka type hota hai:
//
//List<Address>
//Step 3
//
//Humne:
//
//1
//
//pass kiya tha.
//
//Matlab:
//
//sirf 1 address chahiye
//
//To:
//
//addresses.firstOrNull()
//
//nikal lete hain.


//val address =
//    addresses?.firstOrNull()
//
//Ab:
//
//address
//
//ke andar bahut data hai.

//fir->address?.locality
//address?.getAddressLine(0)