package net.aradiata.sfx.music

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import net.aradiata.sfx.SoundChannel

object TestTracks {

    class Test1(override val channel: SoundChannel) : Track {

        override val id: String = "test_1"

        private var isCancelled = false
        private var isFinished = false

        override suspend fun play() {
            while (!isCancelled) {
                println("Playing sound 1!")
                channel.send("addon:tracks.test1")
                delay(8700L)
            }
            isFinished = true
        }

        override suspend fun stop(cause: String?) = coroutineScope {
            isCancelled = true
            while (!isFinished && isActive) { delay(50L) }
        }

    }

    class Test2(override val channel: SoundChannel) : Track {

        override val id: String = "test_2"

        private var isCancelled = false
        private var isFinished = false

        override suspend fun play() {
            while (!isCancelled) {
                channel.send("addon:tracks.test2")
                delay(8700L)
            }
            isFinished = true
        }

        override suspend fun stop(cause: String?) = coroutineScope {
            isCancelled = true
            while (!isFinished && isActive) { delay(50L) }
        }

    }

    class Test3(override val channel: SoundChannel) : Track {

        override val id: String = "test_3"

        private var isCancelled = false
        private var isFinished = false

        override suspend fun play() {
            while (!isCancelled) {
                channel.send("addon:tracks.test3")
                delay(8700L)
            }
            isFinished = true
        }

        override suspend fun stop(cause: String?) = coroutineScope {
            isCancelled = true
            while (!isFinished && isActive) { delay(50L) }
        }

    }

    class Test4(override val channel: SoundChannel) : Track {

        override val id: String = "test_4"

        private var isCancelled = false
        private var isFinished = false

        override suspend fun play() {
            while (!isCancelled) {
                channel.send("addon:tracks.test4")
                delay(8700L)
            }
            isFinished = true
        }

        override suspend fun stop(cause: String?) = coroutineScope {
            isCancelled = true
            while (!isFinished && isActive) { delay(50L) }
        }

    }

    class Linear(override val channel: SoundChannel) : LinearTrack() {

        override val id: String = "addon:tracks.lineartest"
        override val length: Long = 149_000

    }

}