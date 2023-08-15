package PracticeClassesAndCollections.Task7

/*
open class Event (
   val title: String,
   val description: String?= null,
   val daypart: Daypart,
   val durationInMinutes: Int
){
    override fun toString(): String {
        return "Event(title='$title', description='$description', daypart=$daypart, durationInMinutes=$durationInMinutes)"
    }
}*/

  data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
  ){
    val durationOfEvent
        get() = if (this.durationInMinutes < 60){
          "short"
        } else {
          "long"
        }
  }


