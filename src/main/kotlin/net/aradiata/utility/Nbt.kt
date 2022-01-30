package net.aradiata.utility

import net.aradiata.plugin
import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType

class PrimitivePersistentDataType<T>(
    private val primitiveType: Class<T>
) : PersistentDataType<T, T> {
   
    override fun getPrimitiveType(): Class<T> = primitiveType
    
    override fun getComplexType(): Class<T> = primitiveType
    
    override fun toPrimitive(
        complex: T,
        context: PersistentDataAdapterContext
    ): T = complex
    
    override fun fromPrimitive(
        primitive: T,
        context: PersistentDataAdapterContext
    ): T = primitive
    
}

inline fun <reified T> PersistentDataContainer.get(
    key: String,
): T? = get(NamespacedKey(plugin, key), PrimitivePersistentDataType(T::class.java))

inline fun <reified T> ItemMeta.getNbt(
    key: String
): T? = persistentDataContainer.get(key)

inline fun <reified T> PersistentDataContainer.set(
    key: String,
    value: T
): Unit = set(NamespacedKey(plugin, key), PrimitivePersistentDataType(T::class.java), value!!) // !!??

inline fun <reified T> ItemMeta.setNbt(
    key: String,
    value: T
): Unit = persistentDataContainer.set(key, value)