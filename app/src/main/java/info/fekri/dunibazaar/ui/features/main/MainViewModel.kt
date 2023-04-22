package info.fekri.dunibazaar.ui.features.main

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import info.fekri.dunibazaar.model.data.Ads
import info.fekri.dunibazaar.model.data.Product
import info.fekri.dunibazaar.model.repository.product.ProductRepository
import info.fekri.dunibazaar.model.repository.user.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(
    private val productRepository: ProductRepository,
    isInternetConnected: Boolean
) : ViewModel() {

    val dataProducts = mutableStateOf<List<Product>>(listOf())
    val dataAds = mutableStateOf<List<Ads>>(listOf())
    val showProgressBar = mutableStateOf(false)

    init {
        refreshAllDataFromServer(isInternetConnected)
    }

    private fun refreshAllDataFromServer(isInternetConnected: Boolean) {
        viewModelScope.launch {

            if (isInternetConnected) {
                showProgressBar.value = true

                val newDataProducts = async { productRepository.getAllProducts(isInternetConnected) }
                val newDataAds = async { productRepository.getAllAds(isInternetConnected) }

                updateData(newDataProducts.await(), newDataAds.await())

                showProgressBar.value = false
            }

        }
    }

    private fun updateData(products: List<Product>, ads: List<Ads>) {
        dataProducts.value = products
        dataAds.value = ads
    }

}