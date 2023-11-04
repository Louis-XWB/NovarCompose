package com.novar.novarcompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novar.novarcompose.R
import com.novar.novarcompose.ui.theme.NovarComposeTheme

@Composable
fun DiscoveryListTopBar() {
    NovarTopBar(title = "Discovery")
}

@Preview(showBackground = true)
@Composable
fun DiscoveryListTopBarPreview() {
    DiscoveryListTopBar()
}

@Composable
fun DiscoveryListItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(icon), "title", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            title,
            fontSize = 17.sp,
            color = NovarComposeTheme.colors.textPrimary
        )
        badge?.invoke()
        Spacer(Modifier.weight(1f))
        endBadge?.invoke()
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp),
            tint = NovarComposeTheme.colors.more
        )
    }
}

@Composable
fun DiscoveryList() {
    Column(Modifier.fillMaxSize()) {
        DiscoveryListTopBar()
        Box(
            Modifier
                .background(NovarComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            Column(
                Modifier
                    .background(NovarComposeTheme.colors.listItem)
                    .fillMaxWidth()
            ) {
                DiscoveryListItem(R.drawable.ic_moments, "Friend Circle", badge = {
                    Box(
                        Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50))
                            .size(18.dp)
                            .background(NovarComposeTheme.colors.badge)
                    ) {
                        Text(
                            "3",
                            Modifier.align(Alignment.Center),
                            fontSize = 12.sp,
                            color = NovarComposeTheme.colors.onBadge
                        )
                    }
                }, endBadge = {
                    Image(
                        painterResource(R.drawable.avatar_zipcy), "avatar", Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, NovarComposeTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                })
                Spacer(
                    Modifier
                        .background(NovarComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(R.drawable.ic_channels, "Video Channels", endBadge = {
                    Image(
                        painterResource(R.drawable.avatar_weirdo), "avatar", Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, NovarComposeTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Text(
                        "good", Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp),
                        fontSize = 14.sp, color = NovarComposeTheme.colors.textSecondary
                    )
                })
                Spacer(
                    Modifier
                        .background(NovarComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(R.drawable.ic_ilook, "Look Around")
                Divider(
                    Modifier
                        .padding(56.dp, 0.dp, 0.dp, 0.dp)
                        .fillMaxWidth(),
                    color = NovarComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
                DiscoveryListItem(R.drawable.ic_isearch, "Search")
                Spacer(
                    Modifier
                        .background(NovarComposeTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryListItem(R.drawable.ic_nearby, "Nearby")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiscoveryListPreview() {
    NovarComposeTheme {
        DiscoveryList()
    }
}