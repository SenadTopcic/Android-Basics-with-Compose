open class Phone(var isScreenLightOn: Boolean = false){

    protected fun switchOn() {
        isScreenLightOn = true
    }

    protected fun switchOff() {
        isScreenLightOn = false
    }

     fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
