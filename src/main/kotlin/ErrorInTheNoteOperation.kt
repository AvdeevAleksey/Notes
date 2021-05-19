import java.lang.RuntimeException

class ErrorInTheNoteOperation(manager: String) : RuntimeException() {
    override val message: String?
        get() = super.message
}