package com.example.photogram.data

import com.example.photogram.model.Bookmark
import com.example.photogram.model.Comment
import com.example.photogram.model.Like
import com.example.photogram.model.Post
import com.example.photogram.model.User

object FakeData {
    private val posts = mutableListOf(
        Post(
            postID = "1",
            userID = "1",
            location = "Babol",
            photoAddress = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            title = "Beautiful Sunset",
            description = "A stunning view of the sunset in Babol."
        ), Post(
            postID = "2",
            userID = "2",
            location = "Tehran",
            photoAddress = "https://gratisography.com/wp-content/uploads/2024/10/gratisography-cool-cat-800x525.jpg",
            title = "City Lights",
            description = "Tehran's city lights at night are mesmerizing."
        ), Post(
            postID = "3",
            userID = "3",
            location = "Shiraz",
            photoAddress = "https://letsenhance.io/static/a31ab775f44858f1d1b80ee51738f4f3/11499/EnhanceAfter.jpg",
            title = "Historic Architecture",
            description = "Exploring the ancient architecture of Shiraz."
        ), Post(
            postID = "4",
            userID = "4",
            location = "Isfahan",
            photoAddress = "https://f.hellowork.com/blogdumoderateur/2024/04/Midjourney-guide-photorealisme.jpg",
            title = "Bridge at Night",
            description = "The beauty of the Si-o-se-pol bridge under the moonlight."
        ), Post(
            postID = "5",
            userID = "5",
            location = "Mashhad",
            photoAddress = "https://huggingface.co/datasets/huggingfacejs/tasks/resolve/main/image-segmentation/image-segmentation-input.jpeg",
            title = "Peaceful Shrine",
            description = "A moment of peace at the holy shrine in Mashhad."
        ), Post(
            postID = "6",
            userID = "1",
            location = "Babol",
            photoAddress = "https://www.thesprucepets.com/thmb/5OSN_p9hUfPssKsJORQDGnAz_tQ=/1963x0/filters:no_upscale():strip_icc()/GettyImages-181861505-4e63227ed0a14dc9bfe86848ef54caf3.jpg",
            title = "Beautiful Sunset",
            description = "A stunning view of the sunset in Babol."
        ),
        Post(
            postID = "7",
            userID = "1",
            location = "Babol",
            photoAddress = "https://static.vecteezy.com/system/resources/thumbnails/029/511/467/small_2x/a-group-of-cats-taking-a-selfie-on-a-blurred-background-generative-ai-photo.jpg",
            title = "Beautiful Sunset",
            description = "A stunning view of the sunset in Babol."
        )
    )

    private val users = mutableListOf(
        User(
            userID = "1",
            avatar = "https://cdn.britannica.com/36/234736-050-4AC5B6D5/Scottish-fold-cat.jpg",
            userName = "Ahmad",
            bio = "I'm a student."
        ), User(
            userID = "2",
            avatar = "https://images.unsplash.com/photo-1704791403624-c192488ca4fa?q=80&w=2574&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            userName = "Sara",
            bio = "Photographer and traveler."
        ), User(
            userID = "3",
            avatar = "https://plus.unsplash.com/premium_photo-1734203007978-dca43cc0f846?q=80&w=2535&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            userName = "Ali",
            bio = "History enthusiast and writer."
        ), User(
            userID = "4",
            avatar = "https://images.unsplash.com/photo-1733175697085-aa500b61ac74?q=80&w=2572&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            userName = "Maryam",
            bio = "Architecture lover and designer."
        ), User(
            userID = "5",
            avatar = "https://images.unsplash.com/photo-1731505103716-7ee6fa96dee5?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
            userName = "Reza",
            bio = "Tech geek and foodie."
        )
    )

    private val likes = mutableListOf(
        Like(userID = "1", postID = "1"),
        Like(userID = "2", postID = "2"),
        Like(userID = "3", postID = "3"),
        Like(userID = "4", postID = "4"),
        Like(userID = "5", postID = "5"),
        Like(userID = "1", postID = "3"),
        Like(userID = "2", postID = "4")
    )

    private val bookmarks = mutableListOf(
        Bookmark(userID = "1", postID = "2"),
        Bookmark(userID = "2", postID = "3"),
        Bookmark(userID = "1", postID = "1"),
        Bookmark(userID = "4", postID = "5"),
        Bookmark(userID = "1", postID = "4")
    )

    private val comments = mutableListOf(
        Comment(userID = "1", postID = "1", content = "Nice pic"),
        Comment(userID = "2", postID = "1", content = "Awesome!"),
        Comment(userID = "3", postID = "2", content = "Looks great!"),
        Comment(userID = "4", postID = "1", content = "Amazing work!"),
        Comment(userID = "5", postID = "2", content = "Fantastic!")
    )

    fun getPosts(): List<Post> = posts

    fun addPost(post: Post) {
        posts.add(post)
    }

    fun removePost(postId: String) {
        posts.removeIf { it.postID == postId }
    }

    fun getPostById(postId: String): Post? {
        return posts.find { it.postID == postId }
    }

    fun getUsers(): List<User> = users

    fun searchUsersByUsername(searchText: String): List<User> {
        return if (searchText.isBlank()) {
            emptyList()
        } else {
            val regex = Regex(searchText, RegexOption.IGNORE_CASE)
            getUsers().filter { it.userName.contains(regex) }
        }
    }


    fun addUser(user: User) {
        users.add(user)
    }

    fun getUserById(userId: String): User? {
        return users.find { it.userID == userId }
    }

    fun getUserNameById(userId: String): String? {
        return getUserById(userId)?.userName
    }

    fun getUserAvatarById(userId: String): String? {
        return getUserById(userId)?.avatar
    }

    fun getUserPosts(userId: String): List<Post> {
        return posts.filter { userId == it.userID }
    }
    fun getUserLikedPosts(userId: String): List<Post> {
        val likedPosts = likes.filter { userId == it.userID }
        val likedPostIds = likedPosts.map { it.postID }

        return posts.filter { it.postID in likedPostIds }
    }

    fun getUserSavedPosts(userId: String): List<Post> {
        val savedPosts = bookmarks.filter { userId == it.userID }
        val savedPostIds = savedPosts.map { it.postID }

        return posts.filter { it.postID in savedPostIds }
    }

    fun addLike(userId: String, postId: String) {
        if (!likes.any { it.userID == userId && it.postID == postId }) {
            likes.add(Like(userID = userId, postID = postId))
        }
    }

    fun removeLike(userId: String, postId: String) {
        likes.removeIf { it.userID == userId && it.postID == postId }
    }

    fun isPostLikedByUser(userId: String, postId: String): Boolean {
        return likes.any { it.userID == userId && it.postID == postId }
    }

    fun addBookmark(userId: String, postId: String) {
        if (!bookmarks.any { it.userID == userId && it.postID == postId }) {
            bookmarks.add(Bookmark(userID = userId, postID = postId))
        }
    }

    fun removeBookmark(userId: String, postId: String) {
        bookmarks.removeIf { it.userID == userId && it.postID == postId }
    }

    fun isPostBookmarkedByUser(userId: String, postId: String): Boolean {
        return bookmarks.any { it.userID == userId && it.postID == postId }
    }


    fun likeCount(postId: String): Int {
        var counter = 0
        for (item in likes) {
            if (item.postID == postId) counter++
        }
        return counter
    }

    fun commentCount(postId: String): Int {
        var counter = 0
        for (item in comments) {
            if (item.postID == postId) counter++
        }
        return counter
    }

    fun addComment(comment: Comment) {
        comments.add(comment)
    }

    fun getAllCommentsByPostID(postId: String): List<Comment> {
        return comments.filter {
            postId == it.postID
        }
    }
}
