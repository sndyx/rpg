package net.aradiata.ui

interface TextComponent : FixedComponent {

    val y: Int

    fun text(): String

    override fun render(): RenderResult {
        TODO("Not yet implemented")
    }

}