package com.example.driverapp.ui.components
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ImagePreview(
    imageUri: Uri?,
    modifier: Modifier = Modifier
) {
    imageUri?.let {

        AsyncImage(
            model = it,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )

    }
}

//Useage:->
//ImagePreview(
//imageUri = selectedImageUri,
//modifier = Modifier
//.size(120.dp)
//.clip(CircleShape)
//)