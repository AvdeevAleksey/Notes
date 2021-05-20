data class Comment(val commentId:Int = 0,
                   val noteId: Int,
                   val ownerId: Int,
                   val replyTo: Int,    // идентификатор пользователя, ответом на комментарий которого является
                                        // добавляемый комментарий (не передаётся, если комментарий не является ответом).
                   val message: String,  // текст комментария.
                   var deleted: Boolean
                   )
{}