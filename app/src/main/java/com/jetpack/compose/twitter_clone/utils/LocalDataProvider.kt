package com.jetpack.compose.twitter_clone.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.HelpCenter
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Topic
import com.jetpack.compose.twitter_clone.R
import com.jetpack.compose.twitter_clone.ui.componenets.NavigationDrawerBodyItem
import com.jetpack.compose.twitter_clone.ui.states.ChatUiState
import com.jetpack.compose.twitter_clone.ui.states.SpaceCardUiState
import com.jetpack.compose.twitter_clone.ui.states.TrendingListItemUiState
import com.jetpack.compose.twitter_clone.ui.states.TweetUiState
import java.util.Random

object LocalDataProvider {

    fun getNavigationDrawerBodyItems(): List<NavigationDrawerBodyItem> {
        return listOf(
            NavigationDrawerBodyItem(
                "Profile",
                Icons.Default.Person,
                onclick = {
                    println("clicked on Profile")
                }
            ),
            NavigationDrawerBodyItem(
                "Lists",
                Icons.Default.List,
                onclick = {
                    println("clicked on Lists")
                }
            ),
            NavigationDrawerBodyItem(
                "Topics",
                Icons.Default.Topic,
                onclick = {
                    println("clicked on Topics")
                }
            ),
            NavigationDrawerBodyItem(
                "Bookmarks",
                Icons.Default.Bookmark,
            ),
            NavigationDrawerBodyItem(
                "Moments",
                Icons.Default.ElectricBolt,
            ),
            NavigationDrawerBodyItem(
                "Monetization",
                Icons.Default.MonetizationOn
            ),
            NavigationDrawerBodyItem(
                "Twitter for Professionals",
                Icons.Default.RocketLaunch
            ),
            NavigationDrawerBodyItem(
                "Settings and privacy",
                Icons.Default.Settings
            ),
            NavigationDrawerBodyItem(
                "Help Center",
                Icons.Default.HelpCenter
            )
        )
    }
    
    fun getNavigationDrawerBodyItemsNavigationActions(): List< () -> Unit > {
        return listOf(
            {},
            {},
            {},
            {},
        )
    }


    fun getChats(count: Int = 10): List<ChatUiState> {
        val random = Random(System.currentTimeMillis())

        return List(count) {
            ChatUiState(
//                imageId = random.nextInt(10), // Replace with actual image resource IDs
                imageContentDescription = null,
                userName = generateRandomName(random),
                nickName = generateRandomNickName(random),
                lastMessageText = generateRandomMessage(random),
                lastMessageDate = generateRandomDate()
            )
        }
    }

    fun generateRandomName(random: Random): String {
        val firstNames = listOf("Alice", "Bob", "Charlie", "David", "Emily", "Frank", "Grace", "Harry")
        val lastNames = listOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia")
        return "${firstNames[random.nextInt(firstNames.size)]} ${lastNames[random.nextInt(lastNames.size)]}"
    }

    fun generateRandomNickName(random: Random): String {
        val nicknames = listOf("Ace", "Bear", "Cake", "Dizzy", "Echo", "Fox", "Glitch", "Hacker")
        return nicknames[random.nextInt(nicknames.size)]
    }

    fun generateRandomMessage(random: Random): String {
        val messages = listOf("Hey there!", "What's up?", "How's it going?", "Check out this cool thing!", "Busy day?", "See you soon!", "Just thinking of you.")
        return messages[random.nextInt(messages.size)]
    }

//    fun generateRandomDate(): String {
//        val now = System.currentTimeMillis()
//        val randomDaysAgo = Random(now).nextInt(7)
//        val date = now - randomDaysAgo * 24 * 60 * 60 * 1000
//        return date.toString()
//    }

    fun getHomeScreenTweets(): List<TweetUiState> {
        return generateRandomTweets(10)
    }

    fun getSpaces(): List<SpaceCardUiState> {
        return generateRandomSpaceCards(10)
    }

    fun generateTrendingListItems(count: Int = 10): List<TrendingListItemUiState> {
        val labels = listOf("Trending in Egypt", "Popular in Cairo", "Viral in Alexandria", "Top in Giza", "Trending Worldwide")
        val titles = listOf(
            "Watch this amazing video!",
            "This photo is going viral!",
            "Can you believe this story?",
            "Everyone is talking about this!",
            "Don't miss this trending topic!"
        )

        return List(count) {
            TrendingListItemUiState(
                label = labels.random(),
                title = titles.random(),
                numberOfPosts = Random().nextInt()
            )
        }
    }

    fun generateRandomTweets(numTweets: Int): List<TweetUiState> {
        val random = Random()
        val tweets = mutableListOf<TweetUiState>()
        for (i in 0 until numTweets) {
            tweets.add(
                TweetUiState(
                    writerNickName = "User $i",
                    writerUserName = "@User_$i",
                    tweetPublishingDate = generateRandomDate(),
                    tweetContent = generateRandomTweetContent(random),
                    comments = random.nextInt(100),
                    retweets = random.nextInt(1000),
                    loves = random.nextInt(10000),
                    shares = random.nextInt(1000)
                )
            )
        }
        return tweets
    }

    fun generateRandomDate(): String {
        val month = (1..12).random()
        val day = (1..30).random()
        val year = 2023 + Random().nextInt(2) // Generate dates up to current year + 1
        return "$month/$day/$year"
    }

    fun generateRandomTweetContent(random: Random): String {
        val loremIpsum = """
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
  """.trimIndent()
        val maxLength = 280
        val contentLength = random.nextInt(maxLength - 1) + 1 // Generate content between 1 and max characters
        return loremIpsum.substring(0, contentLength)
    }


    fun generateRandomSpaceCards(numSpaces: Int): List<SpaceCardUiState> {
        val random = Random()
        val spaces = mutableListOf<SpaceCardUiState>()
        for (i in 0 until numSpaces) {
            spaces.add(
                SpaceCardUiState(
                    status = if (random.nextBoolean()) "LIVE" else "UPCOMING",
                    title = generateRandomSpaceTitle(random),
                    subtitles = generateRandomSubtitles(random),
                    topListenersImageId = generateTopListenersImageIds(random),
                    numberOfListener = random.nextInt(10000), // Up to 10k listeners
                    hostNickName = "Host $i",
                    hostDescription = generateRandomHostDescription(random)
                )
            )
        }
        return spaces
    }

    fun generateRandomSpaceTitle(random: Random): String {
        val loremIpsum = """
      Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
  """.trimIndent()
        val maxLength = 40
        val contentLength = random.nextInt(maxLength - 1) + 1 // Generate content between 1 and max characters
        return loremIpsum.substring(0, contentLength)
    }

    fun generateRandomSubtitles(random: Random): List<String> {
        val numSubtitles = random.nextInt(3) + 1 // 1 to 3 subtitles
        val subtitles = mutableListOf<String>()
        for (i in 0 until numSubtitles) {
            subtitles.add(generateRandomSpaceTitle(random)) // Reuse logic for shorter subtitles
        }
        return subtitles
    }

    fun generateTopListenersImageIds(random: Random): List<Int> {
        val numListeners = random.nextInt(4) + 1 // 1 to 4 listeners
        val listenerIds = mutableListOf<Int>()
        for (i in 0 until numListeners) {
            listenerIds.add(R.drawable.blue_white) // Replace with your placeholder image resource
        }
        return listenerIds
    }

    fun generateRandomHostDescription(random: Random): String {
        val loremIpsum = """
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
  """.trimIndent()
        val maxLength = 30
        val contentLength = random.nextInt(maxLength - 1) + 1 // Generate content between 1 and max characters
        return loremIpsum.substring(0, contentLength)
    }



}
