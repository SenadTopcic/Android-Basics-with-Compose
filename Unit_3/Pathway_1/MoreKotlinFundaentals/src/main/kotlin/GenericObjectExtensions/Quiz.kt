package GenericObjectExtensions

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.MEDIUM)

    companion object StudentProgress {
        val total: Int = 10
        val answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"


    override fun printProgressBar() {
        repeat(answered){print("▓")}
        repeat(total - answered) {print("▒")}
        println()
        println(progressText)
    }


    fun printQuiz() {
        question1.let {
            println(question1.questionText)
            println(question1.answer)
            println(question1.difficulty)
        }
        println()
        question2.let {
            println(question2.questionText)
            println(question2.answer)
            println(question2.difficulty)
        }
        println()
        question3.let {
            println(question3.questionText)
            println(question3.answer)
            println(question3.difficulty)
        }

        println()
    }

}

