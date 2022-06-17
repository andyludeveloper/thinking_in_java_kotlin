package thinking_in_java

class LiftOff(private var countDown: Int = 10) : Runnable {
    private val id = taskCount++

    companion object {
        var taskCount = 0
    }

    private fun status(): String = if (countDown > 0) {
        "#$id($countDown),"
    } else {
        "#$id(Liftoff!),"
    }

    override fun run() {
        while (countDown-- > 0) {
            println(status())
            Thread.yield()
        }
    }
}

fun main() {
    repeat(5) {
        Thread(LiftOff()).start()
    }
    println("Waiting for Liftoff!")
//    val launch = LiftOff()
//    launch.run()
}