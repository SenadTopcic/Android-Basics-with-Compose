fun main() {
    var celsiusToFahrenheit: (Double) -> Double = { value: Double -> (9.0 / 5.0 * value) + 32}

    var kelvinToCelsius: (Double) -> Double = { value: Double -> (value - 273.25) }
    var fahrenheitToKelvin : (Double) -> Double = {value: Double ->  (5.0/9.0) * (value - 32) + 273.15}

    var temperature: Double = 27.0
    printFinalTemperature(temperature,"Celsius","Fahrenheit") { celsiusToFahrenheit(temperature) }
    temperature = 350.0
    printFinalTemperature(temperature,"Kelvin","Celsius") { kelvinToCelsius(temperature) }
    temperature = 10.0
    printFinalTemperature(temperature,"Fahrenheit","Kelvin") { fahrenheitToKelvin(temperature) }
}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}