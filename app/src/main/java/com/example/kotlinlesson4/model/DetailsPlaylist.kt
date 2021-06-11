package com.example.kotlinlesson4.model


data class DetailsPlaylist(
    val id: Int,
    var playlistApiId: String? = null,
    var items: MutableList<DetailsItem>,
    var nextPageToken: String?
)

data class DetailsItem(
    var snippet: DetailsSnippet,
    var isChange: Boolean = false,
    var startTime: Float = 0f
) {
    override fun toString(): String {
        return "DetailsItem(snippet=$snippet, isChange=$isChange, startTime=$startTime)"
    }
}

data class DetailsSnippet(
    var title: String,
    var description: String,
    var publishedAt: String,
    var thumbnails: Thumbnails,
    var playlistId: String? = null,
    var resourceId: ResourceId? = null
) {
    override fun toString(): String {
        return "DetailsSnippet(title='$title', description='$description', publishedAt='$publishedAt', thumbnails=$thumbnails, playlistId=$playlistId, resourceId=$resourceId)"
    }
}

data class ResourceId(
    var videoId: String? = null
)