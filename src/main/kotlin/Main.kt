package org.example

import kotlinx.coroutines.*
import kotlin.time.measureTime


fun main() {

    /*


        var job = GlobalScope.launch(Dispatchers.Default) {
            println("Started Job 1")
            for (i in 40..50) {
                println(fibonacci(i))
            }
        }






        var job2 = GlobalScope.launch(Dispatchers.Default) {
            println("Started Job 2")
            for (i in 40..50) {
                if (isActive)
                    println(fibonacci(i))
            }

        }




        var job3 = GlobalScope.launch(Dispatchers.Default) {
            println("Started Job3")
            withTimeout(2000) {
                for (i in 40..50) {
                    if (isActive) {
                        println(fibonacci(i))
                    }

                }
            }
        }



        //Let's say we want to cancel "job" after 2000 ms delay
        //This code won't work properly because job is too busy to call cancel() function inside it.
        //So we need to add control block examine job2
        //you can to same operation in the context of job examine job 3


        runBlocking {
            delay(2000)
            job2.cancel()
           }



        //Coroutine
         var job4 = GlobalScope.launch(Dispatchers.Default) {
             repeat(5){
                 println("Coroutine is still working...")
                 delay(1000)
             }
         }
        //Main thread
        runBlocking {
            job4.join()
        }





        val job6 = GlobalScope.launch(Dispatchers.Default) {
            for (i in 40..50){
                println(fibonacci(i))
                delay(1L)
            }
        }

        runBlocking {
            delay(2000)
            job6.cancel()
            println("cancelled")

        }

        Thread.sleep(100000)




        }

     */

    GlobalScope.launch(Dispatchers.IO) {
        val time = measureTime {
            var answer = async { myAwesomeNetworkCall() }
            var answer2 = async { myAwesomeNetworkCall2() }
            println(answer.await())
            println(answer2.await())
        }
        println("Time : $time")

    }

    GlobalScope.launch(Dispatchers.Default) {
        var time = measureTime {
            var myFibonacciAnswer = async {

                fibonacci(40)
            }

            println(myFibonacciAnswer.await())

        }
        println(time)

    }

    Thread.sleep(10000)
}



/**
 * This function returns the parameterized index of
 * fibonacci array.
 * 1,1,2,3,5,8...
 * Example ; fibonacci(4) = 3
 * When you call fibonacci(4) ;
 * fibonacci(4)= fibonacci(3) + fibonacci(2) *
 * fibonacci(3)= fibonacci(2) + fibonacci(1) = fibonacci(1) +fibonacci(0) + fibonacci(1) = 1+0+1=2
 * fibonacci(2)= fibonacci(1) + fibonacci(0) = 1+0=1
 * Therefore, fibonacci(4)= 1+2 = 3
 *
 */
fun fibonacci(n: Int): Int {
    if (n == 0) return 0
    else if (n == 1) return 1
    return fibonacci(n - 1) + fibonacci(n - 2)

}

suspend fun myAwesomeNetworkCall(): String {
    delay(3000)
    return "answer"
}

suspend fun myAwesomeNetworkCall2(): String {
    delay(3000)
    return "answer"
}