package com.example.jsontest.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseProtocolData<T>(val type: String, val payload: T? = null)