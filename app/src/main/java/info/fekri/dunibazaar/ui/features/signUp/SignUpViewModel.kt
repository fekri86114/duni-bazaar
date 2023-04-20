package info.fekri.dunibazaar.ui.features.signUp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.fekri.dunibazaar.model.repository.user.UserRepository

class SignUpViewModel(private val userRepo: UserRepository) : ViewModel() {

    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val confirmPassword = MutableLiveData("")

    fun signUpUser() {
        /* test */
        Log.v("SignUpViewModelDuni", "data -> ${name.value}")
    }

}