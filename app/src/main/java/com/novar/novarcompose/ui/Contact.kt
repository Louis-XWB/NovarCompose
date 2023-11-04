package com.novar.novarcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.novar.novarcompose.NovarViewModel
import com.novar.novarcompose.R
import com.novar.novarcompose.data.User
import com.novar.novarcompose.ui.theme.NovarComposeTheme

@Composable
fun ContactListTopBar() {
    NovarTopBar(title = "Contacts")
}

@Preview(showBackground = true)
@Composable
fun ContactListTopBarPreview() {
    ContactListTopBar()
}

@Composable
fun ContactListItem(
    contact: User,
    modifier: Modifier = Modifier,
) {
    Row(
        Modifier
            .fillMaxWidth()
    ) {
        Image(
            painterResource(contact.avatar), "avatar", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Text(
            contact.name,
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 17.sp,
            color = NovarComposeTheme.colors.textPrimary
        )
    }
}

@Composable
fun ContactList(viewModel: NovarViewModel = viewModel()) {
    Column(Modifier.fillMaxSize()) {
        ContactListTopBar()
        Box(
            Modifier
                .background(NovarComposeTheme.colors.background)
                .fillMaxSize()
        ) {
            ContactList(viewModel.contacts)
        }
    }
}

@Composable
fun ContactList(contacts: List<User>) {
    LazyColumn(
        Modifier
            .background(NovarComposeTheme.colors.listItem)
            .fillMaxWidth()
    ) {
        val buttons = listOf(
            User("contact_add", "New Friends", R.drawable.ic_contact_add),
            User("contact_chat", "Only Chat", R.drawable.ic_contact_chat),
            User("contact_group", "Groups", R.drawable.ic_contact_group),
            User("contact_tag", "Labels", R.drawable.ic_contact_tag),
            User("contact_official", "Public Channels", R.drawable.ic_contact_official),
        )
        itemsIndexed(buttons) { index, contact ->
            ContactListItem(contact)
            if (index < buttons.size - 1) {
                Divider(
                    Modifier
                        .padding(56.dp, 0.dp, 0.dp, 0.dp)
                        .fillMaxWidth(),
                    color = NovarComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }
        item {
            Text(
                "Friends",
                Modifier
                    .background(NovarComposeTheme.colors.background)
                    .fillMaxWidth()
                    .padding(12.dp, 8.dp),
                fontSize = 14.sp,
                color = NovarComposeTheme.colors.onBackground
            )
        }
        itemsIndexed(contacts) { index, contact ->
            ContactListItem(contact)
            if (index < contacts.size - 1) {
                Divider(
                    Modifier
                        .padding(56.dp, 0.dp, 0.dp, 0.dp)
                        .fillMaxWidth(),
                    color = NovarComposeTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListItemPreview() {
    NovarComposeTheme {
        Box {
            ContactListItem(
                User("weirdo", "Weirdo", R.drawable.avatar_weirdo)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    val contacts = listOf<User>(
        User("weirdo", "Weirdo", R.drawable.avatar_weirdo),
        User("zipcy", "Zipcy", R.drawable.avatar_zipcy),
    )
    ContactList(contacts)
}