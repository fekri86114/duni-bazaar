package info.fekri.dunibazaar.model.data

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class AdsResponse(
    val success: Boolean,
    val ads: List<Ads>
): Parcelable

@Parcelize
data class Ads(
    @SerializedName("adId")
    val adId: String,
    @SerializedName("imageURL")
    val imageURL: String,
    @SerializedName("productId")
    val productId: String
) : Parcelable