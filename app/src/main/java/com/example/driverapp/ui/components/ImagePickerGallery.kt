package com.example.learnjetpackcompose.ImagePicker
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

@Composable
fun rememberGalleryPicker(
    onImageSelected: (Uri) -> Unit
): () -> Unit   {
    val launcher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->
            uri?.let(onImageSelected)
        }

    return {
        launcher.launch("image/*")
    }
}
