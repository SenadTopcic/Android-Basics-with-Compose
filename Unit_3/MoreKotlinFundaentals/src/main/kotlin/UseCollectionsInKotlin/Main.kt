package UseCollectionsInKotlin




fun main(args: Array<String>) {
   //foreach method
 //   cookies.forEach{
 //       println("Menu item: ${it.name}")
 //   }

    //map
    val fullMenu = cookies.map { "${it.name} $${it.price}" }
    //fullMenu.forEach{println(it)}

    /*
    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    softBakedMenu.forEach { print("${it.name} ") }
    */
    val groupedMenu = cookies.groupBy {it.softBaked }
    val softBakedMenu  = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    val totalPrice = cookies.fold(0.0){
        total, cookie -> total + cookie.price
    }
    val sortAlpabeticalMenu = cookies.sortedBy { it.name }
    println("Alphabetical menu:")
    sortAlpabeticalMenu.forEach {
        println(it.name)
    }
}