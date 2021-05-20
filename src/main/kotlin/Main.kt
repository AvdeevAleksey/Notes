fun main() {

    val noteService: NoteService = NoteService()
    println(message = noteService.add(Note(title = "title", text = "text")))
    println(message = noteService.add(Note(title = "title2", text = "text2")))
    println(message = noteService.add(Note(title = "title3", text = "text3")))
    println(message = noteService.get())
    noteService.delete(2)
    println(message = noteService.get())
    noteService.edit(Note(noteId = 1, title = "title_change", text = "new string"))
    println(message = noteService.get())
    noteService.delete(2)
}

