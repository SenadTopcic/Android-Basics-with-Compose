    fun main() {
        val amanda = Person("Amanda", 33, "play tennis", null)
        val atiqah = Person("Atiqah", 28, "climb", amanda)


        amanda.showProfile()
        println()
        atiqah.showProfile()
    }
