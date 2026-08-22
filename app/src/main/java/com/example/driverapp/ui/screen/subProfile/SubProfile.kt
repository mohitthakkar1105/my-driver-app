package com.example.driverapp.ui.screen.subProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Male
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Transgender
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.InfoChip
import com.example.driverapp.ui.components.SubcategoriesCard
import com.example.driverapp.ui.model.SubcategoriesCardItemModel
import com.example.driverapp.ui.navigation.AppController

@Composable
fun SubProfile(
    appController: AppController
) {

    val personalInfo = listOf<SubcategoriesCardItemModel>(
        SubcategoriesCardItemModel(
            title = "First Name",
            subTitle = "aman",
            Icon = Icons.Outlined.Person
        ),
        SubcategoriesCardItemModel(
            title = "Last Name",
            subTitle = "Singh",
            Icon = Icons.Outlined.Person
        ),
        SubcategoriesCardItemModel(
            title = "Phone",
            subTitle = "7566850362",
            Icon = Icons.Outlined.Phone
        ),
        SubcategoriesCardItemModel(
            title = "Email",
            subTitle = "aman@gmail.com",
            Icon = Icons.Outlined.Mail
        ),
        SubcategoriesCardItemModel(
            title = "Gender",
            subTitle = "Male",
            Icon = Icons.Outlined.Male
        ),
    )

    val addressInfo = listOf<SubcategoriesCardItemModel>(
        SubcategoriesCardItemModel(
            title = "Address Line 1",
            subTitle = "Indore, Madhya Pradesh, India",
            Icon = Icons.Outlined.Home
        ),
        SubcategoriesCardItemModel(
            title = "Address Line 2",
            subTitle = "Indore, Madhya Pradesh, India",
            Icon = Icons.Outlined.Home
        ),
        SubcategoriesCardItemModel(
            title = "City",
            subTitle = "Delhi, India",
            Icon = Icons.Outlined.LocationCity
        ),
        SubcategoriesCardItemModel(
            title = "State",
            subTitle = "Madhya Pradesh, India",
            Icon = Icons.Outlined.Map
        ),
        SubcategoriesCardItemModel(
            title = "Pincode",
            subTitle = "466464",
            Icon = Icons.Outlined.LocationOn
        ),
    )

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF2E3D9C)
                    )
                    .statusBarsPadding()
                    .wrapContentHeight()
                    .padding(
                        horizontal = 20.dp,
                        vertical = 15.dp
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CustomIcon(
                            icon = Icons.AutoMirrored.Filled.ArrowBack,
                            tint = Color.White
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(
                                shape = RoundedCornerShape(100)
                            )
                            .background(
                                color = Color.Gray
                            )
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(100)
                            )
                    ) {
                        CustomImage(
                            image = R.drawable.app_background,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Aman Singh",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    Row() {
                        InfoChip(
                            text = "Ride Partner",
                            color = Color.White,
                            cornerRadius = 100.dp,
                            borderAlpha = 0.8f,
                            horizontalPadding = 10.dp,
                            fontSize = 12.sp,
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        InfoChip(
                            text = "Account Verified",
                            color = Color.Green,
                            cornerRadius = 100.dp,
                            borderAlpha = 0.8f,
                            horizontalPadding = 10.dp,
                            fontSize = 12.sp,
                            icon = Icons.Rounded.Verified,
                            iconSize = 13
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(
                    color = Color(0xFFF5F6FA)
                )
                .padding(
                    horizontal = 20.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        state = rememberScrollState()
                    )
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                SubcategoriesCard(
                    title = "Personal Information",
                    iconBoxColor = Color(0xFFE8F0FE),
                    iconTint = Color(0xFF3B47A3),
                    icon = Icons.Outlined.Person,
                    onClick = {},
                    listItems = personalInfo
                )
                Spacer(modifier = Modifier.height(10.dp))
                SubcategoriesCard(
                    title = "Address",
                    iconBoxColor = Color(0xFFE0F2F2),
                    iconTint = Color(0xFF129182),
                    icon = Icons.Outlined.LocationOn,
                    onClick = {},
                    listItems = addressInfo
                )
            }
        }
    }
}