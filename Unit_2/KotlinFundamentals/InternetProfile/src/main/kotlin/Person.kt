class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    private var referrerDescription = ""
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")

        if (hobby != null)
            print("Likes to $hobby.")
        if (referrer != null) {
            referrerDescription = " Has a referrer named ${referrer.name}, who like to play ${referrer.hobby}."
        } else {
            referrerDescription = " Doesn't have a referrer"
        }
        println(referrerDescription)
    }
}