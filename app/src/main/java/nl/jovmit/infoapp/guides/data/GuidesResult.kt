package nl.jovmit.infoapp.guides.data

sealed class GuidesResult

data class Progress(val loading: Boolean) : GuidesResult()

data class Success(val guides: List<Guide>) : GuidesResult()

data class Error(val error: String) : GuidesResult()