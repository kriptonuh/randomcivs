package controllers

import handlers.Civ6RandomizeWSHandler
import spark.Filter
import spark.Spark
import spark.Spark.get
import spark.Spark.init
import spark.Spark.port
import spark.Spark.webSocket
import java.util.*


fun main() {
    port(9000)

    webSocket("/randomizer", Civ6RandomizeWSHandler::class.java)
    init()

    get("/hello") { req, res -> "Hello world" }

    val filter = Filter { _, response -> CorsFilter.corsHeaders.forEach { key, value -> response.header(key, value) } }
    Spark.after(filter)
}

object CorsFilter {

    val corsHeaders = HashMap<String, String>()

    init {
        corsHeaders["Access-Control-Allow-Methods"] = "GET,PUT,POST,DELETE,OPTIONS"
        corsHeaders["Access-Control-Allow-Origin"] = "*"
        corsHeaders["Access-Control-Allow-Headers"] = "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,"
        corsHeaders["Access-Control-Allow-Credentials"] = "true"
    }
}