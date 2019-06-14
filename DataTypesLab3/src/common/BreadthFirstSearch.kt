package common

import models.Node
import java.util.*

class BreadthFirstSearch {

    /**
     * Поиск вширину с использованием стека
     *
     * @param node Узел
     */
    fun bfs(nodes: List<Node>, adjacency_matrix: Array<IntArray>, node: Node) {
        val queue = LinkedList<Node>()
        queue.add(node)
        node.visited = true
        while (!queue.isEmpty()) {
            val element = queue.remove()
            print("${element.value} ")

            val neighbours = node.findNeighbours(nodes, adjacency_matrix, element)
            for (i in neighbours.indices) {
                val n = neighbours[i]
                if (n != null && !n.visited) {
                    queue.add(n)
                    n.visited = true
                }
            }
        }
    }
}