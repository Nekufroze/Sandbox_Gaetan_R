package org.mathieu.sandbox.Utils

import android.content.Context
import android.media.MediaPlayer
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.content.ContextCompat
import org.mathieu.sandbox.R


/**
 * Play a sound and vibrate the phone
 * They have been putted together in a single function to make it easier to use
 * and because they are always used together
 */
fun playSoundAndVibrate(context: Context) {
    // Vibrate the phone
    val vibrator = ContextCompat.getSystemService(context, Vibrator::class.java) as Vibrator
    vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))

    // Play a custom sound
    val mediaPlayer = MediaPlayer.create(context, R.raw.picklerick)
    mediaPlayer.start()
}