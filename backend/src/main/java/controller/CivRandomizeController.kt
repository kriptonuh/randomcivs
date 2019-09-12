package controller

import spark.Spark.*

fun main() {
    port(9000)

    get("/hello") { req, res -> "Hello world" }
}