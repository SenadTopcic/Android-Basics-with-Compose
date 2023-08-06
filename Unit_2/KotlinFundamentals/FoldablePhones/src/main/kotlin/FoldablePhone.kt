class FoldablePhone( phoneFolded: Boolean? = true): Phone () {
 private var phoneFolded = phoneFolded
    init {
        if (phoneFolded != null) {
            if (!phoneFolded) {
                println("Its folded and not null")
                switchOn()
            }else {
                    switchOff()
            }
        }else {
            switchOff()
        }
    }
    internal fun phoneFold(){
        phoneFolded = true
        switchOff()
    }
}
