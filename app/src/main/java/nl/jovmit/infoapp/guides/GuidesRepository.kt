package nl.jovmit.infoapp.guides

import android.arch.lifecycle.LiveData
import nl.jovmit.infoapp.guides.data.GuidesResult

interface GuidesRepository {

    fun fetchGuides(): LiveData<GuidesResult>
}