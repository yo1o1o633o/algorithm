package easy;

import java.util.HashMap;
import java.util.Map;

public class JudgeCircle {
    /**
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     *
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     *
     * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
     * */
    public static void main(String[] args) {
        String moves = "UD";
        System.out.println(judgeCircle(moves));
        System.out.println(judgeCircle2(moves));
        System.out.println(judgeCircle3(moves));
    }

    /**
     * Hash表方式判断. 上和下 左和右同时相当即为真
     * */
    private static boolean judgeCircle(String moves) {
        if ("".equals(moves)) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('L', 0);
        map.put('U', 0);
        map.put('D', 0);
        for (int i = 0; i < moves.length(); i++) {
            map.put(moves.charAt(i), map.get(moves.charAt(i)) + 1);
        }
        return map.get('R').equals(map.get('L')) && map.get('U').equals(map.get('D'));
    }

    private static boolean judgeCircle2(String moves) {
        if ("".equals(moves)) {
            return true;
        }
        int l = 0;
        int u = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                l--;
            }
            if (moves.charAt(i) == 'R') {
                l++;
            }
            if (moves.charAt(i) == 'U') {
                u++;
            }
            if (moves.charAt(i) == 'D') {
                u--;
            }
        }
        return l == 0 && u == 0;
    }

    /**
     * switch比if快很多
     * */
    private static boolean judgeCircle3(String moves) {
        int l = 0;
        int u = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    l--;
                    break;
                case 'R':
                    l++;
                    break;
                case 'U':
                    u--;
                    break;
                case 'D':
                    u++;
                    break;
                default:
            }
        }
        return l == 0 && u == 0;
    }
}
