data class Note(val noteId: Int = 0,
                val title: String,
                val text: String,
                var deleted: Boolean = false
                ) {
}