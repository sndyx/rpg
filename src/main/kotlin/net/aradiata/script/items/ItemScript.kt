package net.aradiata.script.items

fun item(id: String, block: ItemScope.() -> Unit) {
    val scope = ItemScope()
    scope.block()
}

class ItemScope {
    
    val events = EventScope()
    
    fun events(block: EventScope.() -> Unit) {
        events.block()
    }

    var rarity = Rarity.Default

    fun rarity(rarity: Rarity) {
        this.rarity = rarity
    }
    
}

class EventScope {

}

fun test() {
    item("lightning-typhoon") {
        rarity(Rarity.Default)
    }
}