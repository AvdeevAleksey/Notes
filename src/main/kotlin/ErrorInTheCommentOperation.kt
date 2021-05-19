import java.lang.RuntimeException

class ErrorInTheCommentOperation(manager: String) : RuntimeException() {
    override val message: String?
        get() = super.message
}