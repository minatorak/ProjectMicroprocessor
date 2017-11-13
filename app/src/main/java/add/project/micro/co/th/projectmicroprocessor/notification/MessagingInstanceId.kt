package add.project.micro.co.th.projectmicroprocessor.notification
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId



class MessagingInstanceId : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
    }
}