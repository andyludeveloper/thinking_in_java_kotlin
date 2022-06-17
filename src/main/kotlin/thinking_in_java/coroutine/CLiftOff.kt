package thinking_in_java.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.*

class CLiftOff(var countDown: Int = 10) : CoroutineScope {
    private val id = taskCount++
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    companion object {
        var taskCount = 0
    }

    private fun status(): String = if (countDown > 0) {
        "#$id($countDown),"
    } else {
        "#$id(Liftoff!),"
    }

    fun run() = launch {
        while (countDown-- > 0) {
            println(status())
            yield()
        }
    }
}

fun main() {
    runBlocking {
        repeat(5) {
            val cLiftoff = CLiftOff()
            cLiftoff.run()
        }
        println("Waiting for Liftoff!")
    }
}