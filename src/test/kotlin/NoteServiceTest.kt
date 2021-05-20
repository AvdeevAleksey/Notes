import org.junit.jupiter.api.Test

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
    fun delete() {

    }

    @Test
    fun edit() {
    }

    @Test
    fun get() {
    }

    @Test
    fun recovery() {
    }

    @Test
    fun getById() {
    }
}