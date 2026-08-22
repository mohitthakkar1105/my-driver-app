package com.example.driverapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.model.SubcategoriesCardItemModel

@Composable
fun SubcategoriesCard(
    title: String,
    iconBoxColor: Color,
    iconTint: Color,
    icon: ImageVector,
    onClick: () -> Unit,
    listItems: List<SubcategoriesCardItemModel>
) {
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
                        .background(color = iconBoxColor),
                    contentAlignment = Alignment.Center
                ) {
                    CustomIcon(
                        icon = icon,
                        tint = iconTint,
                        size = 20
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = iconTint
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 0.51.dp,
                color = Color(0xFFE0E0E0)
            )
            Spacer(modifier = Modifier.height(10.dp))
            listItems.forEachIndexed { index, model ->
                SubCategoriesCardItem(
                    SubCategoriesCardItemTitle = model.title,
                    SubCategoriesCardItemSubtitle = model.subTitle,
                    onClick = onClick,
                    icon = model.Icon
                )
                Spacer(modifier = Modifier.height(13.dp))
            }
        }
    }
}

@Composable
private fun SubCategoriesCardItem(
    SubCategoriesCardItemTitle: String,
    SubCategoriesCardItemSubtitle: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                end = 20.dp
            ),
        verticalAlignment = Alignment.Top
    ) {
        CustomIcon(
            icon = icon,
            tint = Color.Gray,
            size = 19
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = SubCategoriesCardItemTitle,
                fontSize = 14.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = SubCategoriesCardItemSubtitle,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        }
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFFDFF5E8))
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ) {
            CustomIcon(
                icon = Icons.Outlined.Edit,
                tint = Color(0xFF1FAE5C),
                size = 14
            )
        }
    }
}