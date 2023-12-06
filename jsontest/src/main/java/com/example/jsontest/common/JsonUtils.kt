package com.example.jsontest.common

import com.example.jsontest.model.BaseProtocolData
import com.example.jsontest.model.BaseProtocolObjectData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object JsonUtils {
    inline fun<reified T : Any> baseProtocolToJson(data: BaseProtocolData<T>) : String {
        val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

        return if(data.payload == null) {
            val adapter : JsonAdapter<BaseProtocolObjectData> = moshi.adapter(BaseProtocolObjectData::class.java)
            adapter.toJson(BaseProtocolObjectData(data.type))
        } else {
            val type = Types.newParameterizedType(BaseProtocolData::class.java, T::class.java, JsonAdapter::class.java)
            val adapter : JsonAdapter<BaseProtocolData<T>> = moshi.adapter(type)
            adapter.toJson(data)
        }
    }

    inline fun <reified T : Any> jsonToBaseProtocol(jsonString : String): T? {
        val getType = Reflect.getClass<T>(jsonString)

        getType?.objectInstance?.let {
            return it
        }

        val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory())
            .build()
        val type = Types.newParameterizedType(BaseProtocolData::class.java, getType?.java) ?: return null

        val adapter : JsonAdapter<BaseProtocolData<T>> = moshi.adapter(type)
        val result = adapter.fromJson(jsonString)
        return result?.payload
    }

}