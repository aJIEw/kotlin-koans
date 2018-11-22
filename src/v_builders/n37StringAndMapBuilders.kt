package v_builders

import util.TODO
import java.util.*

fun buildStringExample(): String {
    /**
     * 建造者模式，扩展 StringBuilder，函数参数名为扩展方法名 语法：扩展类.(参数) -> 返回值
     * */
    fun buildString(build: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.build()
        return stringBuilder.toString()
    }

    return buildString {
        this.append("Numbers: ")
        for (i in 1..10) {
            // 'this' can be omitted
            append(i)
        }
    }
}

fun todoTask37(): Nothing = TODO(
        """
        Task 37.
        Uncomment the commented code and make it compile.
        Add and implement function 'buildMap' with one parameter (of type extension function) creating a new HashMap,
        building it and returning it as a result.
    """
)

fun <K, V> buildMap(build: MutableMap<K, V>.() -> Unit): Map<K, V> {
    val map = mutableMapOf<K, V>()
    map.build()
    return map
}

fun task37(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
