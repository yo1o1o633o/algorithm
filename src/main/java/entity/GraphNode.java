package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuai.yang
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val, ArrayList<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
