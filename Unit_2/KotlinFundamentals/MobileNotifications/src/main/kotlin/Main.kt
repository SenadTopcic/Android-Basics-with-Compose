fun main() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
    printNotificationSummary(-10)
}
fun printNotificationSummary(notifications: Int?){
    if (notifications != null){
        val result = when{
            notifications < 0 -> "You have negative notifications. Please check your input."
            notifications === 0 -> "You dont have notifications."
            notifications in  1..100 -> "You have $notifications notifications."
            else -> "Your phone is blowing up! You have 99+ notifications."
        }
        println(result)
    }
}
