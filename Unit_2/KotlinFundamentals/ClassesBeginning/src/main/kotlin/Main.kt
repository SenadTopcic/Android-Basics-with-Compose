import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice protected constructor(val name: String, val category: String){

    constructor(name: String,category: String, statusCode: Int) :this(name, category)  {
        deviceStatus = when(statusCode){
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    var deviceStatus = "Online"
        protected set
     private var speakerVolume = 2
        get() = field
    set(value) {
        if (value in 0 ..100){
            field = value
        }
    }

    open val deviceType = "unknown"

    open fun turnOn(){
        deviceStatus = "on"
    }
    open fun turnOff(){
        deviceStatus = "off"
    }

    fun printDeviceInfo(){
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice (deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

        private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
        private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
        private var upChanel:Boolean? = null
    override val deviceType = "Smart TV"
        override fun turnOn() {
            super.turnOn()
            println("Smart TV turned on. Speaker volume set to $speakerVolume.")

        }
    override fun turnOff() {
        super.turnOff()
        println("Smart TV turned off")
    }
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume increased to $speakerVolume.")
    }
    fun nextChannel() {
        channelNumber++
        upChanel= true
        println("Channel number increased to $channelNumber.")
    }
    fun previousChannel() {
        if(upChanel!!) channelNumber--
        else channelNumber++
        println("Channel number increased to $channelNumber.")
    }
}
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

        private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    override val deviceType = "Smart Light"
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
    fun increaseBrightness(){
            brightnessLevel++
        }
    fun decreaseBrightness(){
        brightnessLevel--
    }
}


class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
    ){

    var deviceTurnOnCount = 0
        private set
    fun turnOnTv(){
        if (smartTvDevice.deviceStatus == "off"){
            smartTvDevice.turnOn()
            println(message = "${smartTvDevice.name} was turned on")
        }
    }
    fun turnOffTv(){
        if (smartTvDevice.deviceStatus == "on") {
            smartTvDevice.turnOff()
            println(message = "${smartTvDevice.name} was turned off")
        }
    }
    fun turnOnLight(){
        if (smartLightDevice.deviceStatus == "off") smartLightDevice.turnOn()
    }
    fun turnOffLight(){
        if (smartLightDevice.deviceStatus == "on") smartLightDevice.turnOff()
    }
    fun increaseTvVolume(){
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.increaseSpeakerVolume()
    }
    fun decreaseTvVolume(){
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.decreaseVolume()
    }
    fun changeTvChannelToNext(){
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.nextChannel()
    }
    fun changeTvChannelToPrevious(){
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.previousChannel()
    }
    fun increaseLightBrightness(){
        if (smartLightDevice.deviceStatus == "on") smartLightDevice.increaseBrightness()
    }
    fun decreaseLightBrightness(){
        if (smartLightDevice.deviceStatus == "on") smartLightDevice.decreaseBrightness()
    }
    fun turnOffAllDevices(){
        if (smartTvDevice.deviceStatus == "on") turnOffTv()
        if (smartLightDevice.deviceStatus == "on") turnOffLight()
    }

    fun printSmartTvInfo(){
        if (smartTvDevice.deviceStatus == "on") smartTvDevice.printDeviceInfo()
    }
    fun printSmartLightInfo(){
        if (smartLightDevice.deviceStatus == "on") smartLightDevice.printDeviceInfo()
    }
}

 class RangeRegulator(
     initialValue: Int,
     private val minValue: Int,
     private val maxValue: Int
 ) : ReadWriteProperty<Any?, Int>{
     var fieldData = initialValue

     override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
         return fieldData
     }

     override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
         if (value in minValue..maxValue){
             fieldData = value
         }
     }
 }

fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.turnOnTv()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}.")

    smartHome.smartTvDevice.printDeviceInfo()
}
