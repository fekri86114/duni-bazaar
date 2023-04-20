package info.fekri.dunibazaar.model.data

data class LogInResponse(
    val expiresAt: Int,
    val message: String,
    val success: Boolean,
    val token: String
)