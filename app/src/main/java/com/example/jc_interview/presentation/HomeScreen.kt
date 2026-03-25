package com.example.jc_interview.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jc_interview.Greeting
import com.example.jc_interview.ui.theme.Jc_interviewTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: SongsViewModel= hiltViewModel()) {

    val songs = viewModel.songsList.collectAsState()
    LazyColumn(
        modifier = Modifier. fillMaxSize()
    ) {
        itemsIndexed (songs.value){ index, it->
           SongItem(songName = it.songName,  songLength = it.songLength, isFav = it.isFavourite, songId = it.id,
               onClick = {
                   viewModel.updateSong(it)
               })

           if (index == songs.value.lastIndex) {
               viewModel.loadSongs()
           }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jc_interviewTheme {
        HomeScreen()
    }
}