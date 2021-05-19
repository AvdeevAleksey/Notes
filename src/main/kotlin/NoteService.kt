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
                            }
                        }
            }
        }
    }

    override fun edit(entity: Note) {
        if (!notes.isEmpty()) {
            for ((index, note) in notes.withIndex()) {
                if (note.noteId == entity.noteId) {
                    notes[index] = entity
                }
            }
        }
    }


    override fun get(): List<Note> {
        if (!notes.isEmpty()) {
            var allNotes: List<Note> = for ((index, note) in notes.withIndex()) {
                if (!note.deleted) {
                    add()
                }
            }
        }
    }


}
