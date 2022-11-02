model = 1
name = "Lightning Typhoon"
rarity = Rarity.Legendary

suppressMeleeDamage()
stats {
    magic(95.0)
}

events {
    
    onRightClick { player ->
        player.rayTraceBlocks(20.0)?.getHitBlock()?.let {
            player.world.strikeLightningEffect(it.location)
            val targets = player.world.getNearbyEntities(
                it.location, 5.0, 5.0, 5.0
            )
            repeat(3) {
                targets.forEach { target ->
                    // target.damage(damage.magic)
                }
                delay(500L)
            }
        }
    }
    
}