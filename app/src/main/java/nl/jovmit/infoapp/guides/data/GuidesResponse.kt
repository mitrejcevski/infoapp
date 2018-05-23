package nl.jovmit.infoapp.guides.data

import com.squareup.moshi.Json

data class GuidesResponse(@Json(name = "data") val guides: List<Guide>)