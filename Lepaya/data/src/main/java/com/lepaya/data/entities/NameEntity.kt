package com.lepaya.data.entities


data class NameEntity(
    val first: String,
    val last: String
) {
    fun toFullName(): String {
        return "$first $last"
    }
}