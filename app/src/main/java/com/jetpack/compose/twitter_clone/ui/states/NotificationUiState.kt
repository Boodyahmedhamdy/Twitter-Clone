package com.jetpack.compose.twitter_clone.ui.states

import com.jetpack.compose.twitter_clone.R

data class NotificationUiState(
    val imageId: Int = R.drawable.blue_white,
    val sourceNickName: String = "SourceNickName",
    val sourceUserName: String = "SourceUserName",
    val date: String = "2/4/2022",
    val content: String = "some content here"
)
