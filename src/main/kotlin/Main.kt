package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch


fun main() {


    var job =GlobalScope.launch {
        for (i in 40..50){
            if (isActive){
                println(fibonacci(i))

            }

        }
    }

   GlobalScope.launch {
       launch {
           println("1. scope started")
           job.join()
           println("1. scope finished")
       }


       launch {
           println("2. scope started")
           delay(2000)
           job.cancel()
           println("2. scope finished")
       }
   }



    Thread.sleep(100000)



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
fun fibonacci(n:Int):Int{
    if(n==0) return 0
    else if(n==1) return 1
    return  fibonacci(n-1)+fibonacci(n-2)

}