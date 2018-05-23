package nl.jovmit.infoapp.guides.data

data class Guide(val startDate: String,
                 val endDate: String,
                 val name: String,
                 val url: String,
                 val venue: Venue,
                 val icon: String) {

    fun venue() = buildString {
        append(venue.city)
        if (length > 0 && venue.state.isNotBlank()) {
            append(", ").append(venue.state)
        }
    }
}