package com.novar.novarcompose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.novar.novarcompose.R
import com.novar.novarcompose.data.Chat
import com.novar.novarcompose.data.Message
import com.novar.novarcompose.data.User
import com.novar.novarcompose.ui.theme.NovarComposeTheme
import com.novar.novarcompose.ui.theme.red1

@Composable
fun ChatList(chats: List<Chat>) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(chats) { chat ->
            Row {
                Image(
                    painterResource(chat.friend.avatar), chat.friend.name,
                    Modifier
                        .padding(8.dp)
                        .size(48.dp)
                        .unread(!chat.messages.last().read, NovarComposeTheme.colors.badge)
                        .clip(RoundedCornerShape(4.dp))
                )
                Column(
                    Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        chat.friend.name,
                        fontSize = 16.sp,
                        color = NovarComposeTheme.colors.textPrimary
                    )
                    Text(
                        chat.messages.last().text,
                        fontSize = 14.sp,
                        color = NovarComposeTheme.colors.textSecondary
                    )
                }
                Text(
                    chat.messages.last().time,
                    Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
                    fontSize = 11.sp, color = NovarComposeTheme.colors.textSecondary
                )
            }

            Divider(
                Modifier
                    .padding(60.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                color = NovarComposeTheme.colors.chatListDivider,
                thickness = 0.8.dp
            )
        }
    }
}

fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(
            color,
            5.dp.toPx(),
            Offset(size.width - 1.dp.toPx(), 1.dp.toPx())
        )
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ChatListPreview() {
    ChatList(
        listOf(
            // List<Chat>
            Chat(
                friend = User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
                mutableStateListOf(
                    Message(
                        User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
                        "Working hard at noon",
                        "14:20"
                    ),
                    Message(User.Me, "Sweat drops onto the soil", "14:20"),
                    Message(
                        User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
                        "Who knows meals are hard earned?",
                        "14:20"
                    ),
                    Message(User.Me, "Every grain is hard-earned", "14:20"),
                    Message(
                        User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
                        "The sound of Mulan weaving at the door. Not hearing the loom's sound, just the sighs of a woman.",
                        "14:20"
                    ),
                    Message(
                        User.Me,
                        "Two rabbits running side by side, how can one tell if they are male or female?",
                        "14:20"
                    ),
                    Message(
                        User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
                        "Bright moonlight in front of the bed, thought to be the frost on the ground.",
                        "14:20"
                    ),
                    Message(User.Me, "Shall we eat?", "14:20"),
                )
            ),
            Chat(
                friend = User("weirdo", "Weirdo", R.drawable.avatar_weirdo),
                mutableStateListOf(
                    Message(User("weirdo", "Weirdo", R.drawable.avatar_weirdo), "Hahaha", "13:48"),
                    Message(User.Me, "Haha oh", "13:48"),
                    Message(
                        User("weirdo", "Weirdo", R.drawable.avatar_weirdo),
                        "Why are you laughing?",
                        "13:48"
                    ).apply { read = false },
                )
            ),
        )
    )
}