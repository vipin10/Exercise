package com.vipin.exercise.utils

import android.util.Log
import kotlinx.coroutines.*


class Timer {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Default + job)
    private val TAG="TAG";

    private fun startCoroutineTimer(delayMillis: Long = 0, repeatMillis: Long = 0, action: () -> Unit)
    = scope.launch(Dispatchers.IO) {
        delay(delayMillis)
        if (repeatMillis > 0) {
            while (true) {
                action()
                delay(repeatMillis)
            }
        } else {
            action()
        }
    }

    private val timer: Job = startCoroutineTimer(delayMillis = 0, repeatMillis = 20000) {
        Log.d(TAG, "Background - tick")
//        doSomethingBackground()
        scope.launch(Dispatchers.Main) {
            Log.d(TAG, "Main thread - tick")

        }
    }


    fun startTimer() {
        timer.start()
    }

    fun cancelTimer() {
        timer.cancel()
    }
}
//...