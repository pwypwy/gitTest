package domain

/**
 * 角色
 */
data class Role(
        val name:String,
        val age: Int,
        val grade: Int,
        val party: String,
        val history: String,
        val goods: MutableMap<String,Goods>,
        val attr:MutableMap<String,String>
)

/**
 * 物品
 */
data class Goods(
        val name: String,
        val attr:MutableMap<String,String>
)

