package entity;

import java.util.List;

/**
 * @author shuai.yang
 */
public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> children;

    public MultiTreeNode(int val) {
        this.val = val;
    }

    public MultiTreeNode(int val, List<MultiTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
