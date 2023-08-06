
fun main() {
    val coins: (Int) -> String = { "$it quarters"}
    val cupcake: (Int) -> String = { "Have cupcake!"}

    val treatFunction = trickOfTreat(false) { "${it*2} have Cupcake"}
    val trickFunction = trickOfTreat(true, null)
    treatFunction()
    trickFunction()
    repeat(4){trickFunction()}
}

val trick = {
    println("No Treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}
fun trickOfTreat(isTrick: Boolean, extraTreat : ((Int) -> String)?) : () -> Unit {
    if (isTrick){
        //println(extraTreat(2))
        return trick
    }
    else {
        if (extraTreat != null) {
        println(extraTreat(5))
        }
        return treat
    }
}
