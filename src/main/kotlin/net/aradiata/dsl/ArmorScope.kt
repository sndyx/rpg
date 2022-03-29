package net.aradiata.dsl

class ArmorScope : ItemScope() {
    
    var intent: Intent? = null
    
    fun stats(configuration: ArmorStatScope.() -> Unit) {
    
    }
    
}

class ArmorStatScope {

}