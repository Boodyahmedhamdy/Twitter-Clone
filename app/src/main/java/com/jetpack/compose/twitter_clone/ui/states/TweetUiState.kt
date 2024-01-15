package com.jetpack.compose.twitter_clone.ui.states

import androidx.annotation.DrawableRes
import com.jetpack.compose.twitter_clone.R

data class TweetUiState(
    @DrawableRes
    val writerImageId: Int = R.drawable.blue_white,
    val writerNickName: String = "Writer NickName",
    val writerUserName: String = "Writer UserName",
    val tweetPublishingDate: String = "2/2/2002",
    val tweetContent: String = """
        welcome to my first tweet, 
        it  is good to have some friends around you
        
        done with my pleasure
    """.trimIndent(),
    val comments: Int = 0,
    val retweets: Int = 0,
    val loves: Int = 0,
    val shares: Int = 0
)
