package com.example.jsontest.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseProtocolObjectData(val type: String)