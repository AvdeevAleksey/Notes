import org.junit.Test

import org.junit.jupiter.api.Assertions.*

internal class CommentServiceTest {

    @Test
    fun add_test() {
        val commentService: CommentService = CommentService()
        val expected: Int = 1
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        val result: Int = commentService.comments.size
        assert(expected == result)
    }

    @Test
    fun delete_test_del() {
        val commentService: CommentService = CommentService()
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.delete(1)
        assert(!commentService.comments[0].deleted)
    }

    @Test(expected = ErrorInTheCommentOperation::class)
    fun delete_test_exception() {
        val commentService: CommentService = CommentService()
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.delete(commentService.comments.last().commentId)
        commentService.delete(commentService.comments.last().commentId)
    }

    @Test
    fun edit_test() {
        val commentService: CommentService = CommentService()
        val expected: String = "1"
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.edit(Comment(commentId = commentService.comments.last().commentId, noteId = 1, ownerId = 1, replyTo = 1, message = "1"))
        val result: String = commentService.comments.last().message
        assert(expected == result)
    }

    @Test(expected = ErrorInTheCommentOperation::class)
    fun edit_test_exception() {
        val commentService: CommentService = CommentService()
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.delete(commentService.comments.last().commentId)
        commentService.edit(Comment(commentId = commentService.comments.last().commentId, noteId = 1, ownerId = 1, replyTo = 1, message = ""))
    }

    @Test
    fun get_test() {
        val commentService: CommentService = CommentService()
        val expected: Int = 0
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        assert(expected != commentService.comments.size)
    }

    @Test
    fun get_test_empty() {
        val commentService: CommentService = CommentService()
        val expected: Int = 0
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.comments.clear()
        assert(expected == commentService.comments.size)
    }

    @Test
    fun recovery_test() {
        val commentService: CommentService = CommentService()
        val expected: Boolean = false
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.delete(commentService.comments.last().commentId)
        commentService.recovery(commentService.comments.last().commentId)
        assert(expected == commentService.comments.last().deleted)
    }

    @Test(expected = ErrorInTheCommentOperation::class)
    fun recovery_test_exception() {
        val commentService: CommentService = CommentService()
        commentService.comments.add(Comment(noteId = 1, ownerId = 1, replyTo = 1, message = ""))
        commentService.recovery(commentService.comments.last().commentId)
    }
}