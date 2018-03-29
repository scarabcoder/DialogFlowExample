package com.scarabcoder.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static spark.Spark.*;

public class MainJava {

    public static void main(String... args){

        port(80);

        post("/action", (request, response) -> {
            response.type("application/json");
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(request.body()).getAsJsonObject();
            JsonObject query = obj.getAsJsonObject("queryResult");
            String param = query.getAsJsonObject("parameters").get("server").getAsString();
            System.out.println("Received query action " + query.get("action").getAsString() + " with parameter $param");
            JsonObject res = new JsonObject();
            res.addProperty("fulfillmentText", "5");
            return res.toString();
        });

    }

}
