class CommentService: CrudService<Comment> {

    val comments = mutableListOf<Comment>()

    override fun add(entity: Comment): Int {
        val lastId = if (!comments.isEmpty()) comments.last().commentId + 1 else 1
        comments.add(entity.copy(commentId = lastId))
        return comments.size
    }

    override fun delete(id: Int) {
        if (!comments.isEmpty()) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentId == id) {
                    if (!comments[index].deleted) {
                        comments[index].deleted = true
                    } else throw ErrorInTheCommentOperation("Deletion is not possible. The object has already been deleted.")
                }
            }
        }
    }

    override fun edit(entity: Comment) {
        if (!comments.isEmpty()) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentId == entity.commentId) {
                    if (!comment.deleted) comments[index] = entity else throw ErrorInTheCommentOperation("The change is not possible. The object has already been deleted.")
                }
            }
        }
    }

    override fun get(): List<Comment> {
        if (!comments.isEmpty()) {
            val allComments = mutableListOf<Comment>()
            comments.forEach {
                if (!it.deleted) allComments += Comment(it.noteId, it.commentId, it.ownerId, it.replyTo, it.message, it.deleted)
            }
            return allComments
        } else return emptyList()
    }

    override fun recovery(id: Int) {
        if (!comments.isEmpty()) {
            for ((index, comment) in comments.withIndex()) {
                if (comment.commentId == id) {
                    if (comments[index].deleted) {
                        comments[index].deleted = false
                    } else throw ErrorInTheCommentOperation("Recovery is not possible. The object was not deleted.")
                }
            }
        }
    }
}