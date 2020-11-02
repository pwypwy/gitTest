package doit

import doit.source.lz


fun main() {
    print("开始")

    initSetting()
    Executer.execute("启动")

    println("结束")
}

/**
 * a
 */
fun initSetting() {
    Plan["吃"] = lz.story
}

