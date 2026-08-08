package com.example.driverapp.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectDocumentImage(
    title : String,
    subTitle : String,
    selectLicenceImage : ()-> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(110.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(15.dp),
                color = Color.Gray.copy(
                    alpha = 0.5f
                )
            ).clickable(
                onClick = {
                    selectLicenceImage()
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color = Color.Gray.copy(
                            alpha = 0.2f
                        ),
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                CustomIcon(
                    Icons.Default.DocumentScanner,
                    size = 30,
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(
                modifier = Modifier
                    .width(150.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = subTitle,
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .background(
                        color = Color.Gray.copy(
                            alpha = 0.2f
                        ),
                        shape = RoundedCornerShape(40.dp)
                    )
                    .padding(
                        5.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Upload",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 14.sp
                    )
                )
            }
        }
    }
}