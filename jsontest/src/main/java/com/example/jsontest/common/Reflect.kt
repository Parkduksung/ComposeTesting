package com.example.jsontest.common

import com.example.jsontest.extension.StringExtension.toBaseProtocolType
import com.example.jsontest.model.BaseProtocolData
import org.json.JSONObject
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

/**
 * Created by oykwon on 5/1/23.
 */

object Reflect {
    fun <T: Any> toMap(obj: T): Map<String, Any?> {
        return (obj::class as KClass<T> ).memberProperties.associate { prop ->
            prop.name to prop.get(obj)?.let { value ->
                if (value::class.isData) {
                    toMap(value)
                } else {
                    value
                }
            }
        }
    }

    fun <T: Any> toJson(obj: T): JSONObject {
        val jsonObject = JSONObject()
        (obj::class as KClass<T> ).memberProperties.associate { prop ->
            if(prop.get(obj) != null && prop.get(obj)!!::class.isData) {
                jsonObject.put(prop.name, toJson(prop.get(obj)!!))
            } else {
                jsonObject.put(prop.name, prop.get(obj))
            }
            prop.name to prop.get(obj)?.let { value ->
                if (value::class.isData) {
                    toJson(value)
                } else {
                    value
                }
            }


        }
        return jsonObject

    }

    inline fun <reified T> T.toBaseProtocol(): BaseProtocolData<T> {
        return if(T::class.objectInstance != null) {
            BaseProtocolData(this.toTypeName(), null)
        } else {
            BaseProtocolData(this.toTypeName(), this)
        }
    }

    inline fun <reified T :Any> getClass(string : String) : KClass<out T>? {
        val jsonObject = JSONObject(string)
        val type = jsonObject.getString("type")

        return T::class.sealedSubclasses.find {
            it.simpleName.toBaseProtocolType() == type
        }
    }

    inline fun <reified T> T.toTypeName() : String {
        return T::class.simpleName.toBaseProtocolType()
    }


}
