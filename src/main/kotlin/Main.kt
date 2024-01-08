package org.example

import kotlinx.coroutines.*
import java.io.File
import javax.sound.sampled.AudioSystem

suspend fun playBeats(beats: String, file: String) {
    var parts = beats.split("x")
    var count = 0

    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            delay(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

suspend fun writeByPing(message: String) {
    for (i in 0..5) {
        println(message)
        delay(600)
    }
}

fun writeByPingThread(message: String) {
    for (i in 0..5) {
        println(message)
        Thread.sleep(600)
    }
}

suspend fun playSound(file: String) {
    try {
        val audioInputStream = AudioSystem.getAudioInputStream(File(file))
        val clip = AudioSystem.getClip()
        withContext(Dispatchers.IO) {
            clip.open(audioInputStream)
        }
        clip.start()
        // Sleep to ensure the sound finishes playing before moving to the next
        delay(clip.microsecondLength / 2000)
        clip.close() // Close the clip to release resources
        withContext(Dispatchers.IO) {
            audioInputStream.close()
        } // Close the audio input stream
    } catch (e: Exception) {
        println("Error playing sound: ${e.message}")
    }
}


fun main() {


    val myThread = Thread(Runnable {
        // İş parçacığında yapılacak işlemler
        for (i in 1..5) {
            println("Thread işlemi: $i")
            Thread.sleep(212) // Belirli bir süre uyuma işlemi
        }
    })

    val myThread2 = Thread(Runnable {
        // İş parçacığında yapılacak işlemler
        for (i in 1..5) {
            println("Thread işlemi2: $i")
            Thread.sleep(1000) // Belirli bir süre uyuma işlemi
        }
    })

    myThread.start()
    myThread2.start()

    MyDataType("12") sum "122"


}