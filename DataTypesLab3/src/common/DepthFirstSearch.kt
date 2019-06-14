package common

import models.Node
import java.util.*

class DepthFirstSearch {

    /**
     * Поиск вглубину с использованием стека
     *
     * @param node Узел
     */
    fun dfsUsingStack(nodes: List<Node>, adjacency_matrix: Array<IntArray>, node: Node) {
        val stack = Stack<Node>()
        stack.add(node)
        node.visited = true
        while (!stack.isEmpty()) {
            val element = stack.pop()
            print("${element.value} ")

            val neighbours = node.findNeighbours(nodes, adjacency_matrix, element)
            for (i in neighbours.indices) {
                val n = neighbours[i]
                if (n != null && !n.visited) {
                    stack.add(n)
                    n.visited = true
                }
            }
        }
    }
}