package add.project.micro.co.th.projectmicroprocessor.notification
import com.google.firebase.iid.FirebaseInstanceIdService



class MessagingInstanceId : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
    }
}