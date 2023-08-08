package PracticeClassesAndCollections.Task2

/*
open class Event (
   val title: String,
   val description: String?= null,
   val daypart: Daypart,
   val duration: Int
){
    override fun toString(): String {
        return "Event(title='$title', description='$description', daypart=$daypart, duration=$duration)"
    }
}*/

  data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int
  )
