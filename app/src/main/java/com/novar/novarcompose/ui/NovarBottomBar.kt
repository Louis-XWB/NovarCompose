package com.novar.novarcompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.novar.novarcompose.NovarViewModel
import com.novar.novarcompose.R
import com.novar.novarcompose.ui.theme.NovarComposeTheme

@Composable
fun NovarBottomBar(selected: Int = 0, onSelectedChanged: (Int) -> Unit) {
    val viewModel: NovarViewModel = viewModel()
    Row(Modifier.background(NovarComposeTheme.colors.bottomBar)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            if (selected == 0) NovarComposeTheme.colors.iconCurrent else NovarComposeTheme.colors.icon,
            "Chat",
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(0)
                }
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            if (selected == 1) NovarComposeTheme.colors.iconCurrent else NovarComposeTheme.colors.icon,
            "Contact",
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(1)
                }
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            if (selected == 2) NovarComposeTheme.colors.iconCurrent else NovarComposeTheme.colors.icon,
            "Discovery",
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(2)
                }
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            if (selected == 3) NovarComposeTheme.colors.iconCurrent else NovarComposeTheme.colors.icon,
            "Me",
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(3)
                }
        )
    }
}

@Composable
fun TabItem(@DrawableRes iconId: Int, tint: Color, title: String, modifier: Modifier) {
    Column(
        modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(iconId),
            title,
            Modifier.size(24.dp),
            tint = tint
        )
        Text(title, fontSize = 11.sp, color = tint)
    }
}

//    object

@Preview(showBackground = true)
@Composable
private fun HomeBottomBarPreview() {
    var selectedTab by remember {
        mutableStateOf(0)
    }
    NovarBottomBar(selectedTab) {
        selectedTab = it
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBottomBarPreviewDark() {
    NovarComposeTheme(NovarComposeTheme.Theme.Dark) {
        var selectedTab by remember {
            mutableStateOf(0)
        }
        NovarBottomBar(selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeBottomBarPreviewNewYear() {
    NovarComposeTheme(NovarComposeTheme.Theme.NewYear) {
        var selectedTab by remember {
            mutableStateOf(0)
        }
        NovarBottomBar(selectedTab) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TabItemPreview() {
    TabItem(
        R.drawable.ic_chat_outlined,
        NovarComposeTheme.colors.icon,
        "Chat",
        Modifier.width(100.dp)
    )
}