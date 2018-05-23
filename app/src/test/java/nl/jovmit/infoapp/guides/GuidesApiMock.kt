package nl.jovmit.infoapp.guides

import nl.jovmit.infoapp.guides.data.Guide
import nl.jovmit.infoapp.guides.data.GuidesResponse
import nl.jovmit.infoapp.guides.data.Venue
import retrofit2.Call
import retrofit2.mock.BehaviorDelegate

class GuidesApiMock(private val delegate: BehaviorDelegate<GuidesApi>) : GuidesApi {

    override fun fetchGuides(): Call<GuidesResponse> {
        return delegate.returningResponse(mockedGuidesResponse()).fetchGuides()
    }
}

fun mockedGuidesResponse(): GuidesResponse {
    val guides = (1..10).map {
        Guide("startDate $it",
                "endDate $it",
                "name $it",
                "http://test.com/service/$it",
                mockVenue(it),
                "http://test.com/service/$it.jpg")
    }
    return GuidesResponse(guides)
}

private fun mockVenue(itemId: Int): Venue {
    return Venue("city $itemId", "state $itemId")
}
