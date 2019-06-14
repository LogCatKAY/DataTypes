import common.BreadthFirstSearch
import common.DepthFirstSearch
import models.Node
import java.util.ArrayList

private val nodes = ArrayList<Node>()

//private val adjacencyMatrix = arrayOf(
//    intArrayOf(0, 1, 1, 0, 0, 0, 0), // models.Node 1: D
//    intArrayOf(0, 0, 0, 1, 0, 0, 0), // models.Node 2 :A
//    intArrayOf(0, 1, 0, 1, 1, 1, 0), // models.Node 3: B
//    intArrayOf(0, 0, 0, 0, 1, 0, 0), // models.Node 4: C
//    intArrayOf(0, 0, 0, 0, 0, 0, 1), // models.Node 5: F
//    intArrayOf(0, 0, 0, 0, 0, 0, 1), // models.Node 6: E
//    intArrayOf(0, 0, 0, 0, 0, 0, 0) // models.Node 7: G
//)

private val adjacencyMatrix = arrayOf(
    intArrayOf(0, 1, 1, 1, 1), // models.Node 1: A
    intArrayOf(1, 0, 0, 0, 1), // models.Node 2 :B
    intArrayOf(1, 0, 0, 1, 0), // models.Node 3: C
    intArrayOf(1, 0, 1, 0, 0), // models.Node 4: D
    intArrayOf(1, 1, 0, 0, 0) //  models.Node 5: E
)

//private val adjacencyMatrix = arrayOf(
//    intArrayOf(0, 1, 1, 1, 0, 0), // models.Node 1: A
//    intArrayOf(1, 0, 0, 0, 1, 0), // models.Node 2 : B
//    intArrayOf(1, 0, 0, 0, 0, 0), // models.Node 3: C
//    intArrayOf(1, 0, 0, 0, 0, 1), // models.Node 4: D
//    intArrayOf(0, 1, 0, 0, 0, 0), //  models.Node 5: E
//    intArrayOf(0, 0, 0, 1, 0, 0) //  models.Node 6: F
//)

fun main() {
//    val node4 = Node("D")
//    val node1 = Node("A")
//    val node2 = Node("B")
//    val node3 = Node("C")
//    val node6 = Node("F")
//    val node5 = Node("E")
//    val node7 = Node("G")
//
//    nodes.add(node4)
//    nodes.add(node1)
//    nodes.add(node2)
//    nodes.add(node3)
//    nodes.add(node6)
//    nodes.add(node5)
//    nodes.add(node7)

    val node1 = Node("A")
    val node2 = Node("B")
    val node3 = Node("C")
    val node4 = Node("D")
    val node5 = Node("E")
//    val node6 = Node("F")


    nodes.add(node1)
    nodes.add(node2)
    nodes.add(node3)
    nodes.add(node4)
    nodes.add(node5)
//    nodes.add(node6)

    val depthFirstSearch = DepthFirstSearch()
    println("Обход графа DFS")
    depthFirstSearch.dfsUsingStack(nodes, adjacencyMatrix, node2)
    println()
    clearVisitedFlags(nodes)

    println("Обход графа BFS")
    val breadthFirstSearch = BreadthFirstSearch()
    breadthFirstSearch.bfs(nodes, adjacencyMatrix, node2)
}