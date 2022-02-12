package com.gloomyhub.domain.horror_search.entity

import kotlinx.serialization.Serializable

@Serializable
data class BookshelfEntity(
    val items: List<Item>? = null,
    val kind: String? = null,
    val totalItems: Int? = null
)

@Serializable
data class Item(
    val accessInfo: AccessInfo? = null,
    val etag: String? = null,
    val id: String? = null,
    val kind: String? = null,
    val layerInfo: LayerInfo? = null,
    val saleInfo: SaleInfo? = null,
    val selfLink: String? = null,
    val volumeInfo: VolumeInfo? = null
)

@Serializable
data class AccessInfo(
    val accessViewStatus: String? = null,
    val country: String? = null,
    val embeddable: Boolean? = null,
    val epub: Epub? = null,
    val pdf: Pdf? = null,
    val publicDomain: Boolean? = null,
    val quoteSharingAllowed: Boolean? = null,
    val textToSpeechPermission: String? = null,
    val viewability: String? = null,
    val webReaderLink: String? = null
)

@Serializable
data class LayerInfo(
    val layers: List<Layer>? = null
)

@Serializable
data class SaleInfo(
    val buyLink: String? = null,
    val country: String? = null,
    val isEbook: Boolean? = null,
    val listPrice: ListPrice? = null,
    val offers: List<Offer>? = null,
    val retailPrice: RetailPriceX? = null,
    val saleability: String? = null
)

@Serializable
data class VolumeInfo(
    val allowAnonLogging: Boolean? = null,
    val authors: List<String>? = null,
    val averageRating: Int? = null,
    val canonicalVolumeLink: String? = null,
    val categories: List<String>? = null,
    val contentVersion: String? = null,
    val description: String? = null,
    val imageLinks: ImageLinks? = null,
    val industryIdentifiers: List<IndustryIdentifier>? = null,
    val infoLink: String? = null,
    val maturityRating: String? = null,
    val pageCount: Int? = null,
    val panelizationSummary: PanelizationSummary? = null,
    val previewLink: String? = null,
    val printType: String? = null,
    val publishedDate: String? = null,
    val publisher: String? = null,
    val ratingsCount: Int? = null,
    val readingModes: ReadingModes? = null,
    val title: String? = null
)

@Serializable
data class Epub(
    val acsTokenLink: String? = null,
    val isAvailable: Boolean? = null
)

@Serializable
data class Pdf(
    val acsTokenLink: String? = null,
    val isAvailable: Boolean? = null
)

@Serializable
data class Layer(
    val layerId: String? = null,
    val volumeAnnotationsVersion: String? = null
)

@Serializable
data class ListPrice(
    val amount: Double? = null,
    val currencyCode: String? = null
)

@Serializable
data class Offer(
    val finskyOfferType: Int? = null,
    val listPrice: ListPriceX? = null,
    val retailPrice: RetailPrice? = null
)

@Serializable
data class RetailPriceX(
    val amount: Double? = null,
    val currencyCode: String? = null
)

@Serializable
data class ListPriceX(
    val amountInMicros: Int? = null,
    val currencyCode: String? = null
)

@Serializable
data class RetailPrice(
    val amountInMicros: Int? = null,
    val currencyCode: String? = null
)

@Serializable
data class ImageLinks(
    val smallThumbnail: String? = null,
    val thumbnail: String? = null
)

@Serializable
data class IndustryIdentifier(
    val identifier: String? = null,
    val type: String? = null
)

@Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean? = null,
    val containsImageBubbles: Boolean? = null
)

@Serializable
data class ReadingModes(
    val image: Boolean? = null,
    val text: Boolean? = null)
