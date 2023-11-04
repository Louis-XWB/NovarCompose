package com.novar.novarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.lifecycle.viewmodel.compose.viewModel
import com.novar.novarcompose.ui.ChatPage
import com.novar.novarcompose.ui.Home
import com.novar.novarcompose.ui.theme.NovarComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel: NovarViewModel by viewModels()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: NovarViewModel = viewModel()
            NovarComposeTheme(viewModel.theme) {
                Box {
                    Home(viewModel)
                    ChatPage()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.endChat()) {
            super.onBackPressed()
        }
    }
}