public interface NoteService {

    fun add(id: Int, title: String, text: String) {}
    fun delete(id: Int) {}
    fun edit(id: Int, title: String, text: String) {}
    fun get(ids: List<Int>, userId: Int, count: Int) {}

}