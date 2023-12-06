package com.example.jsontest.extension

object StringExtension {
    fun String?.toBaseProtocolType(): String {
        return this?.replaceFirstChar {
            it.lowercase()
        }?: ""
    }
}