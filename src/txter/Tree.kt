package txter

/**
 * 树
 */
class Tree<T> {
    var data : T? = null
    var tags = setOf<String>()
    var cs = listOf<Tree<T>>()
    // {name}
}

