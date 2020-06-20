package probe.stack;

import entity.GraphNode;

import java.util.*;

/**
 * @author shuai.yang
 */
public class CloneGraph {
    /**
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     *
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     * */
    public static void main(String[] args) {
        GraphNode graphNode1 = new GraphNode(1);
        GraphNode graphNode2 = new GraphNode(2);
        GraphNode graphNode3 = new GraphNode(3);
        GraphNode graphNode4 = new GraphNode(4);
        List<GraphNode> list1 = new ArrayList<>();
        List<GraphNode> list2 = new ArrayList<>();
        List<GraphNode> list3 = new ArrayList<>();
        List<GraphNode> list4 = new ArrayList<>();
        list1.add(graphNode2);
        list1.add(graphNode4);
        list2.add(graphNode1);
        list2.add(graphNode3);
        list3.add(graphNode2);
        list3.add(graphNode4);
        list4.add(graphNode1);
        list4.add(graphNode3);
        graphNode1.neighbors = list1;
        graphNode2.neighbors = list2;
        graphNode3.neighbors = list3;
        graphNode4.neighbors = list4;
        GraphNode graphNode = cloneGraph(graphNode1);
        System.out.println(graphNode);
    }

    private static Map<GraphNode, GraphNode> maps = new HashMap<>();
    /**
     * 使用HashMap存储已经创建的节点. 如果已经创建则返回
     * */
    private static GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        if (maps.containsKey(node)) {
            return maps.get(node);
        }
        GraphNode graphNode = new GraphNode(node.val);
        maps.put(node, graphNode);
        for (GraphNode neighbor : node.neighbors) {
            graphNode.neighbors.add(cloneGraph(neighbor));
        }
        return graphNode;
    }
}
