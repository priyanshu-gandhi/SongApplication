package com.example.jc_interview.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SongItem(modifier: Modifier = Modifier, songName : String ,songLength : String, isFav : Boolean, songId : Int, onClick:(songId : Int) -> Unit) {

    Card(
        modifier = Modifier.fillMaxSize().padding (top=40.dp, start = 16.dp, end=16.dp), shape = RoundedCornerShape(12.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically

        ){
             Text(text =  songName, modifier = Modifier.weight(2f))
             Text(text = songLength,  modifier = Modifier.weight(1f))
             Text(text = if(isFav) "Favourite" else "Not Favourite", modifier.weight(1f).clickable { onClick(songId) })
        }
    }
}