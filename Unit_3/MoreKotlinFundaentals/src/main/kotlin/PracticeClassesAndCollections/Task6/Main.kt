package PracticeClassesAndCollections.Task6

fun main() {
    val event1 = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        Daypart.EVENING ,
        15)

    events.add(event1)
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")

    for (event in shortEvents){
        println(event)
    }

    println("Last event of the day: ${events[events.size - 1].title}")
    println("Last event of the day: ${events.last().title}")
}