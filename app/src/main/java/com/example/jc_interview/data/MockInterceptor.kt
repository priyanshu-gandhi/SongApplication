package com.example.jc_interview.data

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.Response
import okhttp3.Protocol

class MockInterceptor : Interceptor {
    override fun intercept (chain: Interceptor.Chain): Response {

        val request = chain.request()
        val url = request.url

        val page =url.queryParameter("page")?.toIntOrNull() ?: 1

        val jsonResponse = when (page) {
            1 -> """
        [
            {"id": 1, "songName": "Believer", "songLength": "3:00", "isFavourite": true},
            {"id": 2, "songName": "Achiever", "songLength": "3:20", "isFavourite": false},
            {"id": 3, "songName": "Dreamer", "songLength": "4:10", "isFavourite": false},
            {"id": 4, "songName": "Fighter", "songLength": "2:45", "isFavourite": true},
            {"id": 5, "songName": "Warrior", "songLength": "3:30", "isFavourite": false},
            {"id": 6, "songName": "Legend", "songLength": "3:50", "isFavourite": true},
            {"id": 7, "songName": "Rise Up", "songLength": "4:05", "isFavourite": false},
            {"id": 8, "songName": "Champion", "songLength": "3:15", "isFavourite": true},
            {"id": 9, "songName": "Victory", "songLength": "4:00", "isFavourite": true},
            {"id": 10, "songName": "Hope", "songLength": "2:50", "isFavourite": false},
            {"id": 11, "songName": "Glory", "songLength": "3:40", "isFavourite": true},
            {"id": 12, "songName": "Power", "songLength": "3:25", "isFavourite": false}
        ]
    """

            2 -> """
        [
            {"id": 13, "songName": "Focus", "songLength": "3:10", "isFavourite": true},
            {"id": 14, "songName": "Energy", "songLength": "2:55", "isFavourite": false},
            {"id": 15, "songName": "Hustle", "songLength": "3:35", "isFavourite": true},
            {"id": 16, "songName": "Grind", "songLength": "3:05", "isFavourite": false},
            {"id": 17, "songName": "Momentum", "songLength": "3:45", "isFavourite": true},
            {"id": 18, "songName": "Drive", "songLength": "2:40", "isFavourite": false},
            {"id": 19, "songName": "Rise", "songLength": "3:55", "isFavourite": true},
            {"id": 20, "songName": "Pulse", "songLength": "3:15", "isFavourite": false},
            {"id": 21, "songName": "Echo", "songLength": "4:05", "isFavourite": true},
            {"id": 22, "songName": "Blaze", "songLength": "3:25", "isFavourite": false},
            {"id": 23, "songName": "Storm", "songLength": "3:35", "isFavourite": true},
            {"id": 24, "songName": "Zenith", "songLength": "3:50", "isFavourite": false}
        ]
    """

            else -> "[]"
        }.trimIndent()

        return Response.Builder()
            .code(200 )
             .message( "OK")
            .request(request)
            . protocol(Protocol.HTTP_1_1 )
            .body(jsonResponse.toResponseBody("application/json".toMediaType()))
             .build()
    }

}