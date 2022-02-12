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
            return BookItem(entity.id,
                entity.volumeInfo.authors,
                entity.volumeInfo.title,
                entity.volumeInfo.averageRating,
                entity.volumeInfo.categories,
                entity.volumeInfo.description,
                Cover.map(entity.volumeInfo.imageLinks))
        }
    }
}

data class Cover(
    val smallThumbnail: String, val thumbnail: String) {
    companion object {
        fun map(entity: ImageLinks): Cover {
            return Cover(entity.smallThumbnail, entity.thumbnail)
        }
    }
}