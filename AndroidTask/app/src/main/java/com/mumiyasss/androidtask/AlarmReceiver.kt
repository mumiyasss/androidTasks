package com.mumiyasss.androidtask

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat


class AlarmReceiver : BroadcastReceiver() {
    companion object {
        private const val CHANNEL_ID = "ALARM"
    }

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.channel_name)
            val descriptionText = context.getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(context: Context, pendingIntent: PendingIntent): Notification {
        return NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Будильник")
                .setContentText("10 секунд прошло")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()
    }

    override fun onReceive(context: Context, broadcastIntent: Intent) {
        createNotificationChannel(context)
        val intentToWakeUp = Intent(context, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(context, 0, intentToWakeUp,
                PendingIntent.FLAG_UPDATE_CURRENT)
        val notification = createNotification(context, pendingIntent)
        with(NotificationManagerCompat.from(context)) {
            notify(0, notification)
        }
    }
}