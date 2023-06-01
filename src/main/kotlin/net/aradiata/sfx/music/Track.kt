package net.aradiata.sfx.music

import net.aradiata.sfx.SoundChannel

interface Track {

    val id: String
    val channel: SoundChannel

    suspend fun play()

    suspend fun stop(cause: String? = null)

}