package nl.jovmit.infoapp.guides

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import nl.jovmit.infoapp.guides.data.GuidesResult

class GuidesViewModel(private val repository: GuidesRepository) : ViewModel() {

    private val triggerLiveData = MutableLiveData<Long>()

    val guides: LiveData<GuidesResult> by lazy {
        Transformations.switchMap(triggerLiveData) {
            repository.fetchGuides()
        }
    }

    fun fetchGuides() {
        triggerLiveData.value = System.currentTimeMillis()
    }
}