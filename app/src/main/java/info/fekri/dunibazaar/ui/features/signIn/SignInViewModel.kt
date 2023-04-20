package info.fekri.dunibazaar.ui.features.signIn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun signInUser() {
        /* test */
        Log.v("SignInViewModelDuni", "data -> ${email.value}")
    }

}