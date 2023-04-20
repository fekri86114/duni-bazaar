package info.fekri.dunibazaar.ui.features.signIn

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.fekri.dunibazaar.model.repository.user.UserRepository

class SignInViewModel(private val userRepo: UserRepository) : ViewModel() {

    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun signInUser() {
        /* test */
        Log.v("SignInViewModelDuni", "data -> ${email.value}")
    }

}