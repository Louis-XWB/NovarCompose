package com.novar.novarcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.novar.novarcompose.data.Chat
import com.novar.novarcompose.data.Message
import com.novar.novarcompose.data.User

class NovarViewModel : ViewModel() {
    var selectedTab by mutableStateOf(0)

    var chats by mutableStateOf(
        listOf( // List<Chat>
            Chat(
                friend = User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
                mutableStateListOf(
                    Message(User("zipcy", "Zipcy", R.drawable.avatar_zipcy), "Working hard at noon", "14:20"),
                    Message(User.Me, "Sweat drops onto the soil", "14:20"),
                    Message(User("zipcy", "Zipcy", R.drawable.avatar_zipcy), "Who knows meals are hard earned?", "14:20"),
                    Message(User.Me, "Every grain is hard-earned", "14:20"),
                    Message(User("zipcy", "Zipcy", R.drawable.avatar_zipcy), "The sound of Mulan weaving at the door. Not hearing the loom's sound, just the sighs of a woman.", "14:20"),
                    Message(User.Me, "Two rabbits running side by side, how can one tell if they are male or female?", "14:20"),
                    Message(User("zipcy", "Zipcy", R.drawable.avatar_zipcy), "Bright moonlight in front of the bed, thought to be the frost on the ground.", "14:20"),
                    Message(User.Me, "Shall we eat?", "14:20"),
                )
            ),
            Chat(
                friend = User("weirdo", "Weirdo", R.drawable.avatar_weirdo),
                mutableStateListOf(
                    Message(User("weirdo", "Weirdo", R.drawable.avatar_weirdo), "Hahaha", "13:48"),
                    Message(User.Me, "Haha oh", "13:48"),
                    Message(User("weirdo", "Weirdo", R.drawable.avatar_weirdo), "Why are you laughing?", "13:48").apply { read = false },
                )
            ),
        )
    )

}