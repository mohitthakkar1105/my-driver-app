package com.example.driverapp.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.driverapp.ui.model.BottomBarItem

@Composable
fun AppBottomBar(
    selectedIndex: Int = 0,
    onItemClick: (Int) -> Unit
) {

    val items = listOf(

        BottomBarItem(
            title = "Home",
            icon = Icons.Outlined.Home,
        ),

        BottomBarItem(
            title = "Trips",
            icon = Icons.Outlined.History,
        ),

        BottomBarItem(
            title = "Wallet",
            icon = Icons.Outlined.AccountBalanceWallet,
        ),

        BottomBarItem(
            title = "Passes",
            icon = Icons.Outlined.ConfirmationNumber,
        )
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(
                120.dp
            )
            .shadow(
                elevation = 10.dp,
            )
            .background(
                color = Color.White
            )
            .navigationBarsPadding(),

        ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,   // ye line add karo
        ) {
            items.forEachIndexed { index, item ->
                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .width(60.dp)
                        .background(
                            color = if (selectedIndex == index) Color(0xFFF4F7D0) else Color.White,
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(
                            all = 5.dp
                        ).clickable(
                            indication = null,
                            interactionSource = remember {
                                MutableInteractionSource()
                            },
                            onClick = {
                                onItemClick(index)
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center   // SpaceBetween ki jagah Center
                    ) {
                        CustomIcon(
                            icon = item.icon,
                            tint = if(selectedIndex == index) Color.Black else Color(0xFF6B6B6B),
                        )
                        Text(
                            text = item.title,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = if(selectedIndex == index) Color.Black else Color(0xFF6B6B6B)
                        )
                    }
                }
            }
        }
    }
}