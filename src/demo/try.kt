package demo

import domain.Text
import enum.Demand
import java.lang.Exception

fun main() {
    Engine.init(100,CreateRoles)

    Engine.execute()
    Context.print()

}

object Context{
    /**
     * 存储数据
     */
    private val data = mutableMapOf<String,String>()

    /**
     * 取值
     */
    operator fun get(key: String): String {
        return data[key]?:""
    }

    /**
     * 取值
     */
    fun forMap(key: String): Map<String,String> {
        val m = mutableMapOf<String,String>()
        for ((k,v) in data) {
            if(k.startsWith("$key.")){
                m[k] = v
            }
        }
        return m
    }

    /**
     * 集合展示
     */
    fun forSet(key: String): Set<String> {
        val s = mutableSetOf<String>()
        for ((k,v) in data) {
            if(k.startsWith("$key.")){
                s.add(v)
            }
        }
        return s
    }

    /**
     * 存值
     */
    operator fun set(key: String,value: String) {
        data[key] = value
    }

    /**
     * 存map
     */
    operator fun set(key: String,value: Map<String,String>) {
        for ((k,v) in value) {
            data["$key.$k"] = v
        }

    }

    /**
     * 打印
     */
    fun print(){
        println(data)
    }
}

/**
 * 重载运算符
 */
operator fun String.get(k: String):String {
    return k
}

/**
 * 设定接口
 */
interface Setting{

    /**
     * 初始化
     */
    fun init()

    /**
     * 执行
     */
    fun execute()


}

/**
 * 创建角色
 */
object CreateRoles :Setting {
    /**
     * 等级
     */
    private const val DJ = "等级"

    /**
     * 姓名
     */
    private const val NAME = "姓名"

    /**
     * 年龄
     */
    private const val AGE = "年龄"

    override fun init() {
        for (i in 0..100) {
            Context["角色.小明${i}号"] = mapOf(
                    NAME to "小明${i}号",
                    AGE to "$i",
                    DJ to "$i"
            )
        }
    }

    override fun execute() {
        //println("aaaa")
    }
}

/**
 * 核心引擎
 */
object Engine{

    private val settingList = mutableListOf<Setting>()
    private var size = 100
    /**
     * 初始化,加载设定
     */
    fun init(size:Int,vararg ss: Setting) {
        this.size = size
        settingList.addAll(ss)
    }

    fun execute(){
        settingList.init()
        for (i in 1..size) {
            settingList.execute()
        }
    }
}

/**
 * 设定批量初始化
 */
fun List<Setting>.init(){
    this.forEach {
        it.init()
    }
}

/**
 * 设定批量执行
 */
fun List<Setting>.execute(){
    this.forEach {
        it.execute()
    }
}

/**
 * 解决方案集
 */
object SolutionSet{
    private val data = mutableMapOf<Demand,Solution>()

    /**
     * 获取解决方案
     */
    operator fun get(key: Demand):Solution{
        if(!data.containsKey(key)){
            throw Exception("找不到解决方案 $key")
        }
        return data[key]!!
    }

    /**
     * 保存解决方案
     */
    operator fun set(key: Demand,value:Solution){
        if (data.containsKey(key)){
            throw Exception("解决方案重复")
        }
        data[key] = value
    }
}

/**
 * 解决方案
 */
interface Solution{
    fun run()
}

/**
 * 需求池
 */
object DemandQueue{
    private val data = mutableListOf<Demand>()

    /**
     * 输出下一个需求
     */
    fun next():Demand{
        val first= data.first()
        data.removeAt(0)
        return first
    }

    /**
     * 队首插入
     */
    fun toFirst(value: Demand){
        data.add(0,value)
    }

    /**
     * 加入队尾
     */
    fun push(value: Demand){
        //Demand.初始化
        data.add(value)
    }
}