package com.example.example1


class ServerRepository(val api: ServerApi) {
    fun getInsult(language: String, number: Int) = api.getInsult(language, "Hello world!!!", number)
}