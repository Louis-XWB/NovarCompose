package com.novar.novarcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.novar.novarcompose.NovarViewModel
import com.novar.novarcompose.R
import com.novar.novarcompose.ui.theme.NovarComposeTheme

@Composable
fun NovarTopBar(title: String, onBack: (() -> Unit)? = null) {
    Box(
        Modifier
            .background(NovarComposeTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .height(48.dp)
        ) {
            if (onBack != null) {
                Icon(
                    painterResource(R.drawable.ic_back),
                    null,
                    Modifier
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = NovarComposeTheme.colors.icon
                )
            }
            Spacer(Modifier.weight(1f))
            val viewModel: NovarViewModel = viewModel()
            Icon(
                painterResource(R.drawable.ic_palette),
                "Switch Theme",
                Modifier
                    .clickable {
                        viewModel.theme = when (viewModel.theme) {
                            NovarComposeTheme.Theme.Light -> NovarComposeTheme.Theme.Dark
                            NovarComposeTheme.Theme.Dark -> NovarComposeTheme.Theme.NewYear
                            NovarComposeTheme.Theme.NewYear -> NovarComposeTheme.Theme.Light
                        }
                    }
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = NovarComposeTheme.colors.icon
            )
        }
        Text(title, Modifier.align(Alignment.Center), color = NovarComposeTheme.colors.textPrimary)
    }
}