package com.gloomyhub.domain.horror_search.model

import com.gloomyhub.domain.horror_search.entity.ImageLinks
import com.gloomyhub.domain.horror_search.entity.Item

data class BookItem(
    val id: String,
    val authors: List<String>,
    val title: String,
    val averageRating: Int,
    val categories: List<String>,
    val description: String,
    val cover: Cover,
) {
    companion object {
        fun map(entity: Item): BookItem {
            return BookItem(entity.id.orEmpty(),
                entity.volumeInfo?.authors.orEmpty(),
                entity.volumeInfo?.title.orEmpty(),
                entity.volumeInfo?.averageRating?: 0,
                entity.volumeInfo?.categories.orEmpty(),
                entity.volumeInfo?.description.orEmpty(),
                Cover.map(entity.volumeInfo?.imageLinks))
        }
    }
}

data class Cover(
    val smallThumbnail: String, val thumbnail: String) {
    companion object {
        fun map(entity: ImageLinks?): Cover {
            return Cover(entity?.smallThumbnail.orEmpty(), entity?.thumbnail.orEmpty())
        }
    }
}