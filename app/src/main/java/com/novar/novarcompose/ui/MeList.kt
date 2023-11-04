package com.novar.novarcompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novar.novarcompose.R
import com.novar.novarcompose.data.User
import com.novar.novarcompose.ui.theme.NovarComposeTheme

@Composable
fun MeListTopBar() {
    Row(
        Modifier
            .background(NovarComposeTheme.colors.listItem)
            .fillMaxWidth()
            .height(224.dp)
    ) {
        Image(
            painterResource(id = R.drawable.avatar_mfer), contentDescription = "Me",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(6.dp))
                .size(64.dp)
        )
        Column(
            Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                User.Me.name,
                Modifier.padding(top = 80.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = NovarComposeTheme.colors.textPrimary
            )
            Text(
                "WeChat：${User.Me.id}",
                Modifier.padding(top = 16.dp),
                fontSize = 14.sp,
                color = NovarComposeTheme.colors.textSecondary
            )
            Text(
                "+ Status",
                Modifier
                    .padding(top = 16.dp)
                    .border(1.dp, NovarComposeTheme.colors.onBackground, RoundedCornerShape(50))
                    .padding(8.dp, 2.dp),
                fontSize = 16.sp,
                color = NovarComposeTheme.colors.onBackground
            )
        }
        Icon(
            painterResource(id = R.drawable.ic_qrcode), contentDescription = "qrcode",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 20.dp)
                .size(14.dp),
            tint = NovarComposeTheme.colors.onBackground
        )
        Icon(
            painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
            Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp)
                .size(16.dp),
            tint = NovarComposeTheme.colors.more
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MeListTopBarPreview() {
    MeListTopBar()
}

@Composable
fun MeListItem(
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
fun MeList() {
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
            MeListTopBar()
            Spacer(
                Modifier
                    .background(NovarComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            MeListItem(R.drawable.ic_pay, "Pay")
            Spacer(
                Modifier
                    .background(NovarComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            MeListItem(R.drawable.ic_collections, "Collections")
            Divider(
                Modifier
                    .padding(56.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                color = NovarComposeTheme.colors.chatListDivider,
                thickness = 0.8f.dp
            )
            MeListItem(R.drawable.ic_photos, "Friends")
            Divider(
                Modifier
                    .padding(56.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                color = NovarComposeTheme.colors.chatListDivider,
                thickness = 0.8f.dp
            )
            MeListItem(R.drawable.ic_cards, "Cards & Offers")
            Divider(
                Modifier
                    .padding(56.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                color = NovarComposeTheme.colors.chatListDivider,
                thickness = 0.8f.dp
            )
            MeListItem(R.drawable.ic_stickers, "Emoji & Stickers")
            Spacer(
                Modifier
                    .background(NovarComposeTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            MeListItem(R.drawable.ic_settings, "Settings")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeListPreview() {
    NovarComposeTheme {
        MeList()
    }
}