package com.example.driverapp.ui.components
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun CustomImage(
    image: Int,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale
    )
}


//ContentScale.Crop --->poore screen pe image display karwane ke liye
