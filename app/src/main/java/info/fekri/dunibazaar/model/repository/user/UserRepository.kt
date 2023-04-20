package info.fekri.dunibazaar.model.repository.user

interface UserRepository {

    // online
    suspend fun signUp(name: String, userName: String, password: String): String
    suspend fun singIn(userName: String, password: String): String

    // offline
    fun signOut()
    fun loadToken()

    fun saveToken(newToken: String)
    fun getToken(): String

    fun saveUserName(userName: String)
    fun getUserName(): String

}