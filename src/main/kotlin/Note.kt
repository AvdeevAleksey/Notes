data class Note(val noteId: Int,
                val title: String,
                val text: String,
                var deleted: Boolean = false
                ) {
}