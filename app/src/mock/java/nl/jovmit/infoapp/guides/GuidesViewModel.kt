package nl.jovmit.infoapp.guides

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import nl.jovmit.infoapp.guides.data.Guide
import nl.jovmit.infoapp.guides.data.GuidesResult
import nl.jovmit.infoapp.guides.data.Success
import nl.jovmit.infoapp.guides.data.Venue

class GuidesViewModel(val repository: GuidesRepository) : ViewModel() {

    private val triggerLiveData = MutableLiveData<Long>()

    val guides: LiveData<GuidesResult> by lazy {
        Transformations.switchMap(triggerLiveData) {
            mockedResult()
        }
    }

    private fun mockedResult(): LiveData<GuidesResult> {
        val liveData = MutableLiveData<GuidesResult>()
        val guides = (1..10).map {
            Guide("startDate $it",
                    "endDate $it",
                    "name $it",
                    "http://test.com/service/$it",
                    Venue("city $it", "state $it"),
                    "")
        }
        liveData.value = Success(guides)
        return liveData
    }

    fun fetchGuides() {
        triggerLiveData.value = System.currentTimeMillis()
    }
}