package GenericObjectExtensions

interface ProgressPrintable {
    val progressText : String

    fun printProgressBar()
}