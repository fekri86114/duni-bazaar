package info.fekri.dunibazaar.model.repository


object TokenInMemory {
    /**
     * The [userName] is **OPEN** to read but,
     * **CLOSE** to edit (by making setter ***'private'***)
     * */
    var userName: String? = null
        private set

    /**
     * The [token] is **OPEN** to read but,
     * **CLOSE** to edit (by making setter ***'private'***)
     * */
    var token: String? = null
        private set

    fun refreshToken(userName: String?, newToken: String?) {
        this.userName = userName
        this.token = newToken
    }

}