package PracticeClassesAndCollections.Task4

fun main() {

    val morningEvents = events.filter { it.daypart == Daypart.MORNING }
    val afternoonEvents = events.filter { it.daypart == Daypart.AFTERNOON }
    val eveningEvents = events.filter { it.daypart == Daypart.EVENING }

    val eventsByDay: Map<String, Int> = mapOf(
        "morning" to morningEvents.size,
        "afternoon" to afternoonEvents.size,
        "evening" to eveningEvents.size)
    for(event in eventsByDay){
        println("${event.key}: ${event.value}")
    }

    //solution 2
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { daypart, events -> println("$daypart: ${events.size} events") }
}