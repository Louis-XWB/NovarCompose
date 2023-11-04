package com.novar.novarcompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.novar.novarcompose.NovarViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Home(viewModel: NovarViewModel) {
    Column {
        val pagerState = rememberPagerState()
        HorizontalPager(
            pageCount = 4,
            Modifier.weight(1f),
            pagerState
        ) { page ->
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> ContactList()
                2 -> DiscoveryList()
                3 -> MeList()
            }
        }

        val scope = rememberCoroutineScope()
        NovarBottomBar(pagerState.currentPage) {
            scope.launch {
                pagerState.animateScrollToPage(it)
            }
        }
    }
}