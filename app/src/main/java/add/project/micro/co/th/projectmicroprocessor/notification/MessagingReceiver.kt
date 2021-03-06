package add.project.micro.co.th.projectmicroprocessor.notification

import add.project.micro.co.th.projectmicroprocessor.R
import android.app.Notification
import android.graphics.Color
import android.media.RingtoneManager
import android.support.v4.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.PendingIntent
import android.content.Intent
import add.project.micro.co.th.projectmicroprocessor.activity.MainActivity
import android.support.v4.app.NotificationCompat


class MessagingReceiver : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        createNotification(remoteMessage)
    }

    private fun createNotification(remoteMessage: RemoteMessage) {
        val notificationPayload = remoteMessage.notification

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)


        @Suppress("DEPRECATION")
        val notificationBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_washing_machine)
                .setContentTitle(notificationPayload?.title)
                .setContentText(notificationPayload?.body)
                .setAutoCancel(true)
                .setColor(Color.parseColor("#00a3dc"))
                .setLights(Color.RED, 1000, 300)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setContentInfo(notificationPayload?.title)

        val notificationManager = NotificationManagerCompat.from(applicationContext)
        notificationManager.notify(123, notificationBuilder.build())
    }

}