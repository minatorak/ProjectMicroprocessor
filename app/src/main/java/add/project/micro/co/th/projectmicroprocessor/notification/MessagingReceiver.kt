package add.project.micro.co.th.projectmicroprocessor.notification

import add.project.micro.co.th.projectmicroprocessor.R
import android.app.Notification
import android.graphics.Color
import android.media.RingtoneManager
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MessagingReceiver : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        createNotification(remoteMessage)
    }

    private fun createNotification(remoteMessage: RemoteMessage) {
        val notificationPayload = remoteMessage.notification
        val dataPayload = remoteMessage.data

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(notificationPayload?.title)
                .setContentText(notificationPayload?.body)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true)
                .setColor(Color.parseColor("#00a3dc"))
                .setLights(Color.RED, 1000, 300)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSound(defaultSoundUri)

        val notificationManager = NotificationManagerCompat.from(applicationContext)
        notificationManager.notify(123, notificationBuilder.build())
    }

}