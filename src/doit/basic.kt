package doit

interface Doit{
    fun init()
    fun toDo()
}

object Plan{
    val plans:MutableMap<String,Doit> = mutableMapOf()
    operator fun get(key: String): Doit? {
        return plans[key]
    }

    operator fun set(key: String,value:Doit){
        plans[key] = value
    }
}

object eat:Doit{
    override fun init() {
        println("init")
    }

    override fun toDo() {
        print("doit")
    }
}

/**
 * 执行器
 */
object Executer{

    /**
     * 初始化
     */
    private fun init(){
        Plan.plans.forEach { (t, u) ->
            u.init()
        }
    }

    /**
     * 执行
     */
    fun execute(key:String){
        init()
        Plan[key]!!.toDo()
    }

}

/**
 * 存储数据
 */
object Data{
    val vm = mutableMapOf<String,String>()
    val lm = mutableMapOf<String,MutableList<String>>()
    val sm = mutableMapOf<String,MutableSet<String>>()
}

object Text{
    var content:String = ""
}