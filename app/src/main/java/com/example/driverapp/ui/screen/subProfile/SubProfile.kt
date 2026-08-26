package com.example.driverapp.ui.screen.subProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.DriveEta
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Emergency
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.LocationCity
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Male
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Transgender
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.driverapp.R
import com.example.driverapp.ui.components.CustomIcon
import com.example.driverapp.ui.components.CustomImage
import com.example.driverapp.ui.components.InfoChip
import com.example.driverapp.ui.components.SubcategoriesCard
import com.example.driverapp.ui.model.SubcategoriesCardItemModel
import com.example.driverapp.ui.navigation.AppController
import com.example.driverapp.ui.screen.home.HomeViewModel

@Composable
fun SubProfile(
    appController: AppController
) {

    val viewModel = viewModel<SubProfileViewModel>()

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val personalInfo = listOf<SubcategoriesCardItemModel>(
        SubcategoriesCardItemModel(
            title = "First Name",
            subTitle = uiState.firstName,
            Icon = Icons.Outlined.Person
        ),
        SubcategoriesCardItemModel(
            title = "Last Name",
            subTitle = uiState.lastName,
            Icon = Icons.Outlined.Person
        ),
        SubcategoriesCardItemModel(
            title = "Phone",
            subTitle = uiState.phone,
            Icon = Icons.Outlined.Phone
        ),
        SubcategoriesCardItemModel(
            title = "Email",
            subTitle = uiState.email,
            Icon = Icons.Outlined.Mail
        ),
        SubcategoriesCardItemModel(
            title = "Gender",
            subTitle = uiState.gender,
            Icon = Icons.Outlined.Male
        ),
    )

    val addressInfo = listOf<SubcategoriesCardItemModel>(
        SubcategoriesCardItemModel(
            title = "Address Line 1",
            subTitle = uiState.addressLine1,
            Icon = Icons.Outlined.Home
        ),
        SubcategoriesCardItemModel(
            title = "Address Line 2",
            subTitle = uiState.addressLine2,
            Icon = Icons.Outlined.Home
        ),
        SubcategoriesCardItemModel(
            title = "City",
            subTitle = uiState.city,
            Icon = Icons.Outlined.LocationCity
        ),
        SubcategoriesCardItemModel(
            title = "State",
            subTitle = uiState.state,
            Icon = Icons.Outlined.Map
        ),
        SubcategoriesCardItemModel(
            title = "Pincode",
            subTitle = uiState.pinCode,
            Icon = Icons.Outlined.LocationOn
        ),
    )

    val documentsInfo = listOf<SubcategoriesCardItemModel>(
        SubcategoriesCardItemModel(
            title = "Aadhaar",
            subTitle = uiState.aadhaar,
            Icon = Icons.Filled.CreditCard
        ),
        SubcategoriesCardItemModel(
            title = "License",
            subTitle = uiState.license,
            Icon = Icons.Outlined.DriveEta
        ),
    )

    val emergencyContactInfo = listOf<SubcategoriesCardItemModel>(
        SubcategoriesCardItemModel(
            title = "Name",
            subTitle = uiState.emergencyContactName,
            Icon = Icons.Outlined.Person
        ),
        SubcategoriesCardItemModel(
            title = "Email",
            subTitle = uiState.emergencyContactEmail,
            Icon = Icons.Outlined.Email
        ),
        SubcategoriesCardItemModel(
            title = "Phone",
            subTitle = uiState.emergencyContactPhone,
            Icon = Icons.Outlined.Phone
        ),
        SubcategoriesCardItemModel(
            title = "Permanent Home Address",
            subTitle = uiState.emergencyContactHomeAddress,
            Icon = Icons.Outlined.Home
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
                    onClick = {
                        viewModel.onEvent(
                            SubProfileEvent.EditProfileInfo(
                                edit = it
                            )
                        )
                    },
                    listItems = personalInfo,
                    selectedEdit = uiState.personalInfo
                )
                Spacer(modifier = Modifier.height(10.dp))
                SubcategoriesCard(
                    title = "Address",
                    iconBoxColor = Color(0xFFE0F2F2),
                    iconTint = Color(0xFF129182),
                    icon = Icons.Outlined.LocationOn,
                    onClick = {
                        viewModel.onEvent(
                            SubProfileEvent.EditAddressInfo(
                                edit = it
                            )
                        )
                    },
                    listItems = addressInfo,
                    selectedEdit = uiState.address
                )
                Spacer(modifier = Modifier.height(10.dp))
                SubcategoriesCard(
                    title = "Documents",
                    iconBoxColor = Color(0xFFFFA726).copy(
                        alpha = 0.1f
                    ),
                    iconTint = Color(0xFFFFA726),
                    icon = Icons.Outlined.Badge,
                    onClick = {
                        viewModel.onEvent(
                            SubProfileEvent.EditDocumentInfo(
                                edit = it
                            )
                        )
                    },
                    listItems = documentsInfo,
                    selectedEdit = uiState.document
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(15.dp),
                            clip = false
                        )
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(
                            15.dp
                        )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(
                                        color = Color(0xFF9C27B0).copy(
                                            alpha = 0.1f
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                CustomIcon(
                                    icon = Icons.Outlined.Image,
                                    tint = Color(0xFF9C27B0),
                                    size = 20
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Document Images",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF9C27B0)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 0.51.dp,
                            color = Color(0xFFE0E0E0)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Aadhaar Card",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            CustomImage(
                                image = R.drawable.app_background,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = "Driving Licence",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .clip(RoundedCornerShape(10.dp))
                        ) {
                            CustomImage(
                                image = R.drawable.app_background,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                SubcategoriesCard(
                    title = "Emergency Contact",
                    iconBoxColor = Color(0xFFF44336).copy(
                        alpha = 0.1f
                    ),
                    iconTint = Color(0xFFF44336),
                    icon = Icons.Outlined.Emergency,
                    onClick = {
                        viewModel.onEvent(
                            SubProfileEvent.EditEmergencyContactInfo(
                                edit = it
                            )
                        )
                    },
                    listItems = emergencyContactInfo,
                    selectedEdit = uiState.emergencyContact
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(15.dp),
                            clip = false
                        )
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(15.dp)
                        )
                        .padding(15.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(
                                            color = Color(0xFF2196F3).copy(alpha = 0.1f)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CustomIcon(
                                        icon = Icons.Outlined.DirectionsCar,
                                        tint = Color(0xFF2196F3),
                                        size = 20
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "My Vehicles",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF2196F3)
                                )
                            }
                            InfoChip(
                                text = "View All",
                                color = Color(0xFF2196F3),
                                cornerRadius = 100.dp,
                                horizontalPadding = 12.dp,
                                verticalPadding = 6.dp,
                                fontSize = 13.sp,
                                backgroundAlpha = 0.1f,
                                borderAlpha = 0f
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 0.51.dp,
                            color = Color(0xFFE0E0E0)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(
                                        color = Color(0xFF2196F3).copy(alpha = 0.1f)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                CustomIcon(
                                    icon = Icons.Outlined.DirectionsCar,
                                    tint = Color(0xFF2196F3),
                                    size = 26
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Tata Nexon",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF1A1A1A)
                                )
                                Text(
                                    text = "MP09123457",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF2196F3)
                                )
                                Text(
                                    text = "Hatchback",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )
                            }
                            InfoChip(
                                text = "Verified",
                                color = Color(0xFF4CAF50),
                                cornerRadius = 100.dp,
                                horizontalPadding = 10.dp,
                                verticalPadding = 5.dp,
                                fontSize = 12.sp,
                                backgroundAlpha = 0.1f,
                                borderAlpha = 0f
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}