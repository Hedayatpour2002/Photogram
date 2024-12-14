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
            photoAddress = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            title = "City Lights",
            description = "Tehran's city lights at night are mesmerizing."
        ), Post(
            postID = "3",
            userID = "3",
            location = "Shiraz",
            photoAddress = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            title = "Historic Architecture",
            description = "Exploring the ancient architecture of Shiraz."
        ), Post(
            postID = "4",
            userID = "4",
            location = "Esfahan",
            photoAddress = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            title = "Bridge at Night",
            description = "The beauty of the Si-o-se-pol bridge under the moonlight."
        ), Post(
            postID = "5",
            userID = "5",
            location = "Mashhad",
            photoAddress = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            title = "Peaceful Shrine",
            description = "A moment of peace at the holy shrine in Mashhad."
        )
    )

    private val users = mutableListOf(
        User(
            userID = "1", userName = "Ahmad", bio = "I'm a student."
        ), User(
            userID = "2",
            avatar = "https://sholaemmanuel.com/wp-content/uploads/2024/06/photo-1570295999919-56ceb5ecca61.jpg",
            userName = "Sara",
            bio = "Photographer and traveler."
        ), User(
            userID = "3",
            avatar = "https://sholaemmanuel.com/wp-content/uploads/2024/06/photo-1570295999919-56ceb5ecca61.jpg",
            userName = "Ali",
            bio = "History enthusiast and writer."
        ), User(
            userID = "4",
            avatar = "https://sholaemmanuel.com/wp-content/uploads/2024/06/photo-1570295999919-56ceb5ecca61.jpg",
            userName = "Maryam",
            bio = "Architecture lover and designer."
        ), User(
            userID = "5",
            avatar = "https://sholaemmanuel.com/wp-content/uploads/2024/06/photo-1570295999919-56ceb5ecca61.jpg",
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
        Comment(userID = "1", postID = "1", content = "Nice pic")
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

    fun getLikes(): List<Like> = likes

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
}
