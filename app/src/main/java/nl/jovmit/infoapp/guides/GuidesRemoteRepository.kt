package nl.jovmit.infoapp.guides

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import nl.jovmit.infoapp.extensions.retrofitCallback
import nl.jovmit.infoapp.guides.data.*

class GuidesRemoteRepository(private val api: GuidesApi) : GuidesRepository {

    private val guidesLiveData = MutableLiveData<GuidesResult>()

    override fun fetchGuides(): LiveData<GuidesResult> {
        guidesLiveData.value = Progress(true)
        api.fetchGuides().enqueue(retrofitCallback(::fetchSuccess, ::fetchError))
        return guidesLiveData
    }

    private fun fetchSuccess(guidesResponse: GuidesResponse?) {
        guidesLiveData.value = Progress(false)
        guidesResponse?.let {
            guidesLiveData.value = Success(it.guides)
        }
    }

    private fun fetchError(error: String) {
        guidesLiveData.value = Progress(false)
        guidesLiveData.value = Error(error)
    }
}