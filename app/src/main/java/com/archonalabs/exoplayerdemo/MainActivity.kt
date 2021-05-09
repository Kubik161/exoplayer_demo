package com.archonalabs.exoplayerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.archonalabs.exoplayerdemo.databinding.ActivityMainBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var player : SimpleExoPlayer
    private val contentUri : String = "https://demo.unified-streaming.com/video/tears-of-steel/tears-of-steel.ism/.mpd"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        playStream()
    }

    private fun playStream() {

        //create player, attach it to view
        player = SimpleExoPlayer.Builder(this).build()
        binding.styledPlayerView.player = player

        //create item to play
        val mediaItem: MediaItem = MediaItem.fromUri(contentUri)
        player.setMediaItem(mediaItem)

        //prepare player
        player.prepare()

        //and play
        player.play()
    }

    override fun onStop() {
        super.onStop()

        player.release()
    }
}