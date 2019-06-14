package models

import java.util.ArrayList

class Node(_value: String = "_") {
    var value: String = "_"
    var visited: Boolean
    var neighbours: MutableList<Node>?

    init {
        value = _value
        visited = false
        neighbours = ArrayList()
    }

    /**
     * Найти соседей узла, используя матрицу смежности
     * Если adjacencyMatrix [i] [j] == 1, то узлы с индексом i и индексом j связаны
     *
     * @param nodes           Список узлов
     * @param adjacencyMatrix Матрица смежности
     * @param node            Узел
     * @return Список узлов
     */
    fun findNeighbours(nodes: List<Node>, adjacencyMatrix: Array<IntArray>, node: Node): List<Node> {
        var nodeIndex = -1

        val neighbours = ArrayList<Node>()
        for (i in nodes.indices) {
            if (nodes[i] == node) {
                nodeIndex = i
                break
            }
        }

        if (nodeIndex != -1) {
            for (j in 0 until adjacencyMatrix[nodeIndex].size) {
                if (adjacencyMatrix[nodeIndex][j] == 1) {
                    neighbours.add(nodes[j])
                }
            }
        }
        return neighbours
    }
}