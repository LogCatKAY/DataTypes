import models.Node

fun clearVisitedFlags(nodes: List<Node>) {
    nodes.forEach { node -> node.visited = false }
}