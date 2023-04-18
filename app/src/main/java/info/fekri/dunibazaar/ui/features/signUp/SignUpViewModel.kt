package info.fekri.dunibazaar.ui.features.signUp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")

    fun signUpUser() {
        /* test */
        Log.v("DuniBazaarApp", "data -> ${name.value}")
    }

}