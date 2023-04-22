package info.fekri.dunibazaar.model.repository.product

import info.fekri.dunibazaar.model.data.Ads
import info.fekri.dunibazaar.model.data.Product
import info.fekri.dunibazaar.model.db.ProductDao
import info.fekri.dunibazaar.model.net.ApiService

class ProductRepositoryImpl(
    private val apiService: ApiService,
    private val productDao: ProductDao
): ProductRepository {
    override suspend fun getAllProducts(isInternetConnected: Boolean): List<Product> {
        if (isInternetConnected) {
            // get data from internet
            val dataFromServer = apiService.getAllProducts()
            if (dataFromServer.success) {
                productDao.insertOrUpdate(dataFromServer.products)
                return dataFromServer.products
            }
        } else {
            // get data from local-db
            return productDao.getAll()
        }

        return listOf()
    }

    override suspend fun getAllAds(isInternetConnected: Boolean): List<Ads> {
        if (isInternetConnected) {
            // get ads
            val dataFromServer = apiService.getAllAds()
            if (dataFromServer.success) {
                return dataFromServer.ads
            }
        }

        return listOf()
    }
}