package nl.jovmit.infoapp.extensions

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val retrofit by lazy {
    setupRetrofit()
}

private fun setupRetrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl("https://guidebook.com/service/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}

fun <T> retrofitCallback(success: ((T?) -> Unit)? = null,
                         failure: ((String) -> Unit)? = null): Callback<T> {

    return object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            response?.let {
                if (it.isSuccessful) {
                    success?.invoke(it.body())
                } else {
                    failure?.invoke(it.message())
                }
            }
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            val responseBody = t?.message ?: "network_error"
            failure?.invoke(responseBody)
        }
    }
}