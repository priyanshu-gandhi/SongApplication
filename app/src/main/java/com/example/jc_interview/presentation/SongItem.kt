package com.example.jc_interview.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SongItem(modifier: Modifier = Modifier, songName : String ,songLength : String, isFav : Boolean, songId : Int, onClick:(songId : Int) -> Unit) {

    Card(
        modifier = Modifier.fillMaxSize()
    ){
        Row(){
             Text(text =  songName)
             Text(text = songLength)
             Text(text = if(isFav) "Favourite" else "Not Favourite", modifier.clickable { onClick(songId) })
        }
    }
}