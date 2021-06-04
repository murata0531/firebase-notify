package com.example.firebase_notify

import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyMessagingService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        // 端末＋アプリを一意に識別するためのトークンを取得
        Log.i("FIREBASE", "[SERVICE] Token = ${p0 ?: "Empty"}")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        showNotification(
            remoteMessage.notification?.title,
            remoteMessage.notification?.body
        )
    }

    fun showNotification(title: String?, message: String?) {
        val builder = NotificationCompat.Builder(this, "MyNotification").apply {
            setContentTitle(title)
            setAutoCancel(true)
            setContentText(message)
        }
        NotificationManagerCompat.from(this).notify(999, builder.build())
    }

}