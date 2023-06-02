package net.aradiata.ui

import net.aradiata.player.controller
import net.aradiata.text.NO_OUTLINE
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.entity.Player

class ManaBarComponent(private val player: Player) : FixedComponent {

    override val x: Int = 11

    companion object {

        private val offset = UIComponent.offset(-1)

        val manaBar: Map<Int, String> = List(21) {
            Pair(it, buildManaBar(it))
        }.toMap()

        private fun buildManaBar(mana: Int): String {
            val builder = StringBuilder()
            builder.append(when (mana) {
                0 -> '\uE105'
                1 -> '\uE104'
                else -> '\uE103'
            }).append(offset)
            repeat(mana / 2 - if (mana == 20) 2 else 1) {
                builder.append('\uE100').append(offset)
            }
            when (mana) {
                20 -> builder.append('\uE106')
                19 -> builder.append('\uE107')
                else -> {
                    if (mana % 2 == 1 && mana != 1) builder.append('\uE101').append(offset)
                    repeat((20 - mana) / 2 - if (mana == 0) 2 else 1) {
                        builder.append('\uE102').append(offset)
                    }
                    builder.append('\uE108')
                }
            }
            return builder.toString()
        }

    }

    override fun render(): RenderResult {
        val state = player.controller.state
        val bar = TextComponent(manaBar[(state.mana / state.maxMana * 20).toInt()])
        bar.color = NO_OUTLINE
        return RenderResult(arrayOf(TextComponent(bar)), 80)
    }

}