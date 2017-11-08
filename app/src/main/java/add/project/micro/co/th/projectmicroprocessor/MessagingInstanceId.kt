package add.project.micro.co.th.projectmicroprocessor
import com.google.firebase.iid.FirebaseInstanceIdService

class MessagingInstanceId : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
    }
}