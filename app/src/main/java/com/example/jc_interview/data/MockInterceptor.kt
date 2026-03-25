package com.example.jc_interview.data

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Response
import okhttp3.Protocol

class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {

        val jsonResponse = """
            [
                {
                    "id": 1,
                    "songName": "Shape of You",
                    "songLength": "4:20",
                    "isFavourite": true
                },
                {
                    "id": 2,
                    "songName": "Believer",
                    "songLength": "3:45",
                    "isFavourite": false
                },
                {
                    "id": 3,
                    "songName": "Closer",
                    "songLength": "4:10",
                    "isFavourite": false
                }
            ]
        """.trimIndent()

        return Response.Builder()
            .code(200)
            .message(jsonResponse)
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .body(
                jsonResponse.toResponseBody("application/json".toMediaType())
            )
            .build()
    }

}