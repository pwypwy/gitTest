fun main() {

    println("${Human.eat()} ${Human.eat("西瓜")} ${Human.eat("小明","冬瓜")}")

}

object Human{
    fun eat():String{
        return "吃东西"
    }
    fun eat(food:String):String{
        return "吃$food"
    }
    fun eat(role:String,food:String):String{
        return "${role}吃$food"
    }
}

object Txt{
    var content:String = ""
    fun print() {
        println(content)
    }
}