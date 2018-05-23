package nl.jovmit.infoapp

import retrofit2.Retrofit
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import java.util.concurrent.TimeUnit

fun <T> setupBehaviorDelegateFor(type: Class<T>): BehaviorDelegate<T> {
    val retrofit = Retrofit.Builder().baseUrl("https://test.com/api/").build()
    val behavior = NetworkBehavior.create()
    behavior.setDelay(0, TimeUnit.MILLISECONDS)
    behavior.setErrorPercent(0)
    behavior.setFailurePercent(0)
    behavior.setVariancePercent(0)
    val mockRetrofit = MockRetrofit.Builder(retrofit).networkBehavior(behavior).build()
    return mockRetrofit.create<T>(type)
}