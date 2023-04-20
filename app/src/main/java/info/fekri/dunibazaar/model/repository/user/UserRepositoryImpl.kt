package info.fekri.dunibazaar.model.repository.user

import android.content.SharedPreferences
import com.google.gson.JsonObject
import info.fekri.dunibazaar.model.net.ApiService
import info.fekri.dunibazaar.model.repository.TokenInMemory
import info.fekri.dunibazaar.util.VALUE_SUCCESS

class UserRepositoryImpl(
    private val apiService: ApiService,
    private val sharedPref: SharedPreferences
) : UserRepository {

    override suspend fun signUp(name: String, userName: String, password: String): String {

        val jsonObject = JsonObject().apply {
            addProperty("name", name)
            addProperty("userName", userName)
            addProperty("password", password)
        }

        val result = apiService.signUp(jsonObject)
        return if (result.success) {
            TokenInMemory.refreshToken(userName, result.token)
            saveToken(result.token)
            saveUserName(userName)

            VALUE_SUCCESS
        } else {
            result.message
        }

    }

    override suspend fun singIn(userName: String, password: String): String {

        val jsonObject = JsonObject().apply {
            addProperty("email", userName)
            addProperty("password", password)
        }

        val result = apiService.signIn(jsonObject)
        return if (result.success) {
            TokenInMemory.refreshToken(userName, result.token)
            saveToken(result.token)
            saveUserName(userName)

            VALUE_SUCCESS
        } else {
            result.message
        }

    }

    override fun signOut() {
        TokenInMemory.refreshToken(null, null)
        sharedPref.edit().clear().apply()
    }

    /**
     * [getToken] and [getUserName] are coming from sharedPreferences.
     * ---
     * **CASHING** in **MEMORY**
     * */
    override fun loadToken() {
        TokenInMemory.refreshToken( getUserName(), getToken() )
    }

    override fun saveToken(newToken: String) {
        sharedPref.edit().putString("token", newToken).apply()
    }

    override fun getToken(): String = sharedPref.getString("token", "")!!

    override fun saveUserName(userName: String) {
        sharedPref.edit().putString("username", userName).apply()
    }

    override fun getUserName(): String = sharedPref.getString("username", "")!!

}