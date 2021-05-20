class NoteService: CrudService<Note> {

    val notes = mutableListOf<Note>()

    override fun add(entity: Note): Int {
        notes.add(entity)
        return notes.size
    }

    override fun delete(id: Int) {
        if (!notes.isEmpty()) {
            for ((index, note) in notes.withIndex()) {
                if (note.noteId == id) {
                    if (!notes[index].deleted) {
                        notes[index].deleted = true
                    } else throw ErrorInTheNoteOperation("Deletion is not possible. The object has already been deleted.")
                }
            }
        }
    }

    override fun edit(entity: Note) {
        if (!notes.isEmpty()) {
            for ((index, note) in notes.withIndex()) {
                if (note.noteId == entity.noteId) {
                    if (!note.deleted) notes[index] =
                        entity else throw ErrorInTheNoteOperation("The change is not possible. The object has already been deleted.")
                }
            }
        }
    }


    override fun get(): List<Note> {
        if (!notes.isEmpty()) {
            val allNotes = mutableListOf<Note>()
            notes.forEach {
                if (!it.deleted) allNotes += Note(it.noteId, it.title, it.text, it.deleted)
            }
            return allNotes
        } else return emptyList()
    }

    override fun recovery(id: Int) {
        if (!notes.isEmpty()) {
            for ((index, note) in notes.withIndex()) {
                if (note.noteId == id) {
                    if (notes[index].deleted) {
                        notes[index].deleted = false
                    } else throw ErrorInTheNoteOperation("Recovery is not possible. The object was not deleted.")
                }
            }
        }
    }

    fun getById(id: Int): Note? {
        return notes.find { it.noteId == id && !it.deleted }
    }
}
