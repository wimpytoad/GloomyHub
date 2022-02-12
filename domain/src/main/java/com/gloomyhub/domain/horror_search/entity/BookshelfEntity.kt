package com.gloomyhub.domain.horror_search.entity

import kotlinx.serialization.Serializable

@Serializable
data class BookshelfEntity(
    val items: List<Item>? =  null,
    val kind: String,
    val totalItems: Int
)

@Serializable
data class Item(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

@Serializable
data class AccessInfo(
    val accessViewStatus: String,
    val country: String,
    val embeddable: Boolean,
    val epub: Epub,
    val pdf: Pdf,
    val publicDomain: Boolean,
    val quoteSharingAllowed: Boolean,
    val textToSpeechPermission: String,
    val viewability: String,
    val webReaderLink: String
)

@Serializable
data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val authors: List<String>,
    val averageRating: Int,
    val canonicalVolumeLink: String,
    val categories: List<String>,
    val contentVersion: String,
    val description: String,
    val imageLinks: ImageLinks,
    val infoLink: String,
    val maturityRating: String,
    val pageCount: Int,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val publishedDate: String,
    val publisher: String,
    val ratingsCount: Int,
    val readingModes: ReadingModes,
    val title: String
)

@Serializable
data class Epub(
    val acsTokenLink: String,
    val isAvailable: Boolean)

@Serializable
data class Pdf(
    val acsTokenLink: String,
    val isAvailable: Boolean
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)

@Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)

@Serializable
data class ReadingModes(
    val image: Boolean,
    val text: Boolean
)