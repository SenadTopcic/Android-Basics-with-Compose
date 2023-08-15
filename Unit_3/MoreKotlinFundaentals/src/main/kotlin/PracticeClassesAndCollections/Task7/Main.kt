package PracticeClassesAndCollections.Task7

fun main() {

    val duraationOfEvent = if (events[0].durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }
    println("Duration of first event of the day: $duraationOfEvent")



    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}