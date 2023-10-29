package com.novar.novarcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.novar.novarcompose.ui.ChatList
import com.novar.novarcompose.ui.NovarBottomBar
import com.novar.novarcompose.ui.theme.NovarComposeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovarComposeTheme {
                Column {
                    val viewModel: NovarViewModel = viewModel()
                    HorizontalPager(pageCount = 4) { page ->
                        when (page) {
                            0 -> ChatList(viewModel.chats)
                            1 -> Box(modifier = Modifier.fillMaxSize())
                            2 -> Box(modifier = Modifier.fillMaxSize())
                            3 -> Box(modifier = Modifier.fillMaxSize())
                        }
                    }
                    NovarBottomBar(viewModel.selectedTab) {
                        viewModel.selectedTab = it
                    }

                }
            }
        }
    }
}