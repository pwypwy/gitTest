package domain

fun main() {
    Engine.build()
    Text.print()
}

/**
 *
 */
fun init() {

}

object Context {
    object Lead{
        var name = "小明"
        var grade = 0
        var equip  = listOf<String>()
    }

    val roles = mutableMapOf<String,Role>()

    object Npc{
        /**
         * 获取
         */
        fun get(name: String){

        }
    }


}

/**
 * 上下文相关
 */
object Event{
    /**
     * 升级
     */
    fun upgrade(): String {
        Context.Lead.grade++

        return "${Context.Lead.name}打小怪兽,升到了${Context.Lead.grade}级.\n"
    }
}

/**
 * 引擎
 */
object Engine{
    /**
     * 构建
     */
    fun build() {
        while(Context.Lead.grade < 100){
           Event.upgrade().write()
        }
    }
}

object Text{
    var content = ""

    /**
     * 打印
     */
    fun print() {
        println(content)
    }
}

/**
 *
 */
fun String.write() {
    Text.content += this
}