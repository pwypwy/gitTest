package txter

enum class Direction {NORTH, SOUTH, WEST, EAST }
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
        override fun ok() = "23"
    },

    TALKING {
        override fun signal() = WAITING
        override fun ok() = "23"
    };

    abstract fun signal(): ProtocolState
    abstract fun ok():String
}

val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

fun main() {

    2 in setOf(1,2,3)
    println(Direction.NORTH)
    ProtocolState.TALKING.ok()
}

//主线 , 支线 , 装饰族

//脉络型设定

//装饰型设定 包含,比例

//结构化

//层次化

//分段输出

//可调试

//持久化

//版本控制

//多态统计
