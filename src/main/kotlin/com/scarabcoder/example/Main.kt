package com.scarabcoder.example

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import spark.Spark.*
import spark.kotlin.Http
import spark.kotlin.ignite

object Main {

    @JvmStatic
    fun main(args: Array<out String>) {
        val http: Http = ignite()
        http.port(80)
        http.post("/action") {
            response.type("application/json")
            val parser = JsonParser()
            val obj = parser.parse(request.body()) as JsonObject
            val query = obj.getAsJsonObject("queryResult")
            val param = query.getAsJsonObject("parameters")["server"].asString
            println("Received query action ${query["action"].asString} with parameter $param")
            val res = JsonObject()
            res.addProperty("fulfillmentText", "5")
            res.toString()
        }
    }


}