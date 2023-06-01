package net.aradiata.ui

import net.md_5.bungee.api.chat.ComponentBuilder

class FixedStackComponent(
    components: MutableList<FixedComponent>
) : StackComponent<FixedComponent>(components) {

    override fun addComponent(component: FixedComponent) {
        super.addComponent(component)
        // Sort for more compact UI string
        components.sortBy { it.x }
    }

    override fun render(): RenderResult {
        var x = 0
        val cb = ComponentBuilder()
        for (component in components) {
            val offset = UIComponent.offset(component.x - x)
            val result: RenderResult = component.render()
            // Realign current X position
            x = component.x + result.width
            cb.append(offset)
            cb.append(result.result)
        }
        cb.append(UIComponent.offset(-x))
        return RenderResult(cb.create(), 0)
    }
}
