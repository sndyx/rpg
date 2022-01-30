package net.aradiata.script

fun item(id: String, block: ItemScope.() -> Unit) {

}

class ItemScope {
    
    val events = EventScope()
    
    fun events(block: EventScope.() -> Unit) {
        events.block()
    }
    
}

class EventScope {

}

fun test() {
    item("lightning-typhoon") {
    
    }
}