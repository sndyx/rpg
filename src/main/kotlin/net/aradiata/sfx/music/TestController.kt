package net.aradiata.sfx.music

import net.aradiata.sfx.SoundChannel
import net.aradiata.util.boundingBox
import org.bukkit.util.BoundingBox

object TestController : LocationTrackController {

    override val map: Map<BoundingBox, (SoundChannel) -> Track> = mapOf(
        boundingBox(-8, 0, -172, -13, 255, -176) to { TestTracks.Test1(it) },
        boundingBox(-13, 0, -172, -18, 255, -176) to { TestTracks.Test2(it) },
        boundingBox(-18, 0, -172, -23, 255, -176) to { TestTracks.Test3(it) },
        boundingBox(-23, 0, -172, -28, 255, -176) to { TestTracks.Test4(it) },
        boundingBox(-31, 0, -172, -36, 255, -176) to { TestTracks.Linear(it) }
    )

    override val handled: List<String> = listOf(
        "addon:tracks.test1",
        "addon:tracks.test2",
        "addon:tracks.test3",
        "addon:tracks.test4",
        "addon:tracks.lineartest"
    )

}