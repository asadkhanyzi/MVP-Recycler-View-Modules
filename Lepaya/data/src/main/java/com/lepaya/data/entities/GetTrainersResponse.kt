package com.lepaya.data.entities

import com.lepaya.domain.models.Trainer

data class GetTrainersResponse(
    val id: String?,
    val createdAt: String,
    val name: NameEntity,
    val avatar: String,
    val index: Int,
    val guid: String,
    val isAvailable: Boolean,
    val picture: String,
    val email: String,
    val about: String,
    val bornDate: String,
    val tags: List<String>,
    val favoriteFruit: String
) {

    fun toTrainer(): Trainer {
        return Trainer(
            id = id  ?: id.orEmpty(),
            createdAt = createdAt,
            fullName = name.toFullName(),
            avatar = avatar,
            index = index,
            guid = guid,
            isAvailable = isAvailable,
            picture = picture,
            email = email,
            about = about,
            bornDate = bornDate,
            tags = tags.joinToString(separator = "\n"),
            favoriteFruit = favoriteFruit
        )
    }
}
