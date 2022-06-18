package thinking_in_java.exercise.exercise1

class P1A : Runnable {
    companion object {
        const val TAG = "P1A"
    }

    init {
        println("[$TAG]: init")
    }

    override fun run() {
        repeat(3) {

            println("[$TAG]: Hello")
            Thread.yield()
            println("[$TAG]: finish")
        }
        return
    }
}

class P1B : Runnable {
    companion object {
        const val TAG = "P1B"
    }

    init {
        println("[$TAG]: init")
    }

    override fun run() {
        repeat(3) {
            println("[$TAG]: Hello")
            Thread.yield()
            println("[$TAG]: finish")
        }
        return
    }
}

class P1C : Runnable {
    companion object {
        const val TAG = "P1C"
    }

    init {
        println("[$TAG]: init")
    }

    override fun run() {
        repeat(3) {
            println("[$TAG]: Hello")
            Thread.yield()
            println("[$TAG]: finish")
        }
        return
    }
}

fun main() {
    println("********* Beginning of main() *********");
    repeat(2) {
        Thread(P1A()).start()
        Thread(P1B()).start()
        Thread(P1C()).start()
    }
    println("********* End of main() *********");
}