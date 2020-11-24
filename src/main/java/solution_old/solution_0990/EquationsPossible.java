package solution_old.solution_0990;

public class EquationsPossible {
    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     *
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
     * */
    public static void main(String[] args) {
        String[] equations = {"a==c","c==d","d==z"};
        System.out.println(equationsPossible(equations));
    }

    /**
     * 使用并查集形式来处理
     * 1. 先判断相等式
     * 2. 再判断不等式， 如果不等式的两个元素在相等式的集合中， 就产生了冲突。 此时返回false
     * */
    private static boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // parent 0~25
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }

        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
    private static int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}
