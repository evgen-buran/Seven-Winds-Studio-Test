import android.widget.Toast
import com.buranchikov.sevenwindsstudiotest.MainActivity
import com.buranchikov.sevenwindsstudiotest.api.AppAPI

lateinit var APP_ACTIVITY: MainActivity
lateinit var APP_API:AppAPI

val TAG = "myLog"
val BASE_URL = "http://147.78.66.203:3210/"


fun showToast(str: String) {
    Toast.makeText(APP_ACTIVITY, str, Toast.LENGTH_SHORT).show()
}
