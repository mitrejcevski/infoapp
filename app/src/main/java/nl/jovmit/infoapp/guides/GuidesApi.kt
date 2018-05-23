package nl.jovmit.infoapp.guides

import nl.jovmit.infoapp.guides.data.GuidesResponse
import retrofit2.Call
import retrofit2.http.GET

interface GuidesApi {

    @GET("v2/upcomingGuides/")
    fun fetchGuides(): Call<GuidesResponse>
}