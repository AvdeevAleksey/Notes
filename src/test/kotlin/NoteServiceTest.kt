import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class NoteServiceTest {

    @Test
    fun add_test() {
        val noteService: NoteService = NoteService()
        val expected: Int = 1
        noteService.notes.add(Note(title = "", text = ""))
        val result: Int = noteService.notes.size
        assert(expected == result)
    }

    @Test
    fun delete_test_del() {
        val noteService: NoteService = NoteService()
        noteService.notes.add(Note(title = "", text = ""))
        noteService.delete(1)
        assert(!noteService.notes[0].deleted)
    }

    @Test(expected = ErrorInTheNoteOperation::class)
    fun delete_test_exception() {
        val noteService: NoteService = NoteService()
        noteService.notes.add(Note(title = "", text = ""))
        noteService.delete(noteService.notes.last().noteId)
        noteService.delete(noteService.notes.last().noteId)
    }

    @Test
    fun edit_test() {
        val noteService: NoteService = NoteService()
        val expected: String = "1"
        noteService.notes.add(Note(title = "", text = ""))
        noteService.edit(Note(noteId = noteService.notes.last().noteId, title = "1", text = ""))
        val result: String = noteService.notes.last().title
        assert(expected == result)
    }

    @Test(expected = ErrorInTheNoteOperation::class)
    fun edit_test_exception() {
        val noteService: NoteService = NoteService()
        noteService.notes.add(Note(title = "", text = ""))
        noteService.delete(noteService.notes.last().noteId)
        noteService.edit(Note(noteId = noteService.notes.last().noteId, title = "", text = ""))
    }

    @Test
    fun get_test() {
        val noteService: NoteService = NoteService()
        val expected: Int = 0
        noteService.notes.add(Note(title = "", text = ""))
        assert(expected != noteService.notes.size)
    }

    @Test
    fun get_test_empty() {
        val noteService: NoteService = NoteService()
        val expected: Int = 0
        noteService.notes.add(Note(title = "", text = ""))
        noteService.notes.clear()
        assert(expected == noteService.notes.size)
    }

    @Test
    fun recovery_test() {
        val noteService: NoteService = NoteService()
        val expected: Boolean = false
        noteService.notes.add(Note(title = "", text = ""))
        noteService.delete(noteService.notes.last().noteId)
        noteService.recovery(noteService.notes.last().noteId)
        assert(expected == noteService.notes.last().deleted)
    }

    @Test(expected = ErrorInTheNoteOperation::class)
    fun recovery_test_exception() {
        val noteService: NoteService = NoteService()
        noteService.notes.add(Note(title = "", text = ""))
        noteService.recovery(noteService.notes.last().noteId)
    }

    @Test
    fun getById_test() {
        val noteService: NoteService = NoteService()
        noteService.notes.add(Note(title = "", text = ""))
        val expected: Note = noteService.notes.last().copy()
        assert(expected == noteService.getById(noteService.notes.last().noteId))
    }
}