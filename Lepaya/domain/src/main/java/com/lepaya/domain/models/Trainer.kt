package com.lepaya.domain.models

data class Trainer(
    val id: String?,
    val createdAt: String,
    val fullName: String,
    val avatar: String,
    val index: Int,
    val guid: String,
    val isAvailable: Boolean,
    val picture: String,
    val email: String,
    val about: String,
    val bornDate: String,
    val tags: String,
    val favoriteFruit: String
)
