package PracticeClassesAndCollections.Task3



fun main() {
    val event1 = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        Daypart.EVENING ,
        15)

    events.add(event1)

    for (event in events) println(event)
}