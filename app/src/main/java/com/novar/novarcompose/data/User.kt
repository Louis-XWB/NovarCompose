package com.novar.novarcompose.data

import androidx.annotation.DrawableRes
import com.novar.novarcompose.R

class User(val id: String, val name: String, @DrawableRes val avatar: Int) {
    companion object {
        val Me: User = User("novar", "Novar", R.drawable.avatar_mfer)
    }
}