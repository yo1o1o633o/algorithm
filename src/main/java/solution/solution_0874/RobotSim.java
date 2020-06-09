package solution.solution_0874;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuai.yang
 */
public class RobotSim {
    /**
     * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
     *
     * -2：向左转 90 度
     * -1：向右转 90 度
     * 1 <= x <= 9：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物。
     *
     * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
     *
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
     *
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
     * */
    public static void main(String[] args) {
        int[] commands = {1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5,-2,6,6,7,7,2,8,9,-1,7,4,6,9,9,9,-1,5,1,3,3,-1,5,9,7,4,8,-1,-2,1,3,2,9,3,-1,-2,8,8,7,5,-2,6,8,4,6,2,7,2,-1,7,-2,3,3,2,-2,6,9,8,1,-2,-1,1,4,7};
        int[][] obstacles = {{-57,-58},{-72,91},{-55,35},{-20,29},{51,70},{-61,88},{-62,99},{52,17},{-75,-32},{91,-22},{54,33},{-45,-59},{47,-48},{53,-98},{-91,83},{81,12},{-34,-90},{-79,-82},{-15,-86},{-24,66},{-35,35},{3,31},{87,93},{2,-19},{87,-93},{24,-10},{84,-53},{86,87},{-88,-18},{-51,89},{96,66},{-77,-94},{-39,-1},{89,51},{-23,-72},{27,24},{53,-80},{52,-33},{32,4},{78,-55},{-25,18},{-23,47},{79,-5},{-23,-22},{14,-25},{-11,69},{63,36},{35,-99},{-24,82},{-29,-98},{-50,-70},{72,95},{80,80},{-68,-40},{65,70},{-92,78},{-45,-63},{1,34},{81,50},{14,91},{-77,-54},{13,-88},{24,37},{-12,59},{-48,-62},{57,-22},{-8,85},{48,71},{12,1},{-20,36},{-32,-14},{39,46},{-41,75},{13,-23},{98,10},{-88,64},{50,37},{-95,-32},{46,-91},{10,79},{-11,43},{-94,98},{79,42},{51,71},{4,-30},{2,74},{4,10},{61,98},{57,98},{46,43},{-16,72},{53,-69},{54,-96},{22,0},{-7,92},{-69,80},{68,-73},{-24,-92},{-21,82},{32,-1},{-6,16},{15,-29},{70,-66},{-85,80},{50,-3},{6,13},{-30,-98},{-30,59},{-67,40},{17,72},{79,82},{89,-100},{2,79},{-95,-46},{17,68},{-46,81},{-5,-57},{7,58},{-42,68},{19,-95},{-17,-76},{81,-86},{79,78},{-82,-67},{6,0},{35,-16},{98,83},{-81,100},{-11,46},{-21,-38},{-30,-41},{86,18},{-68,6},{80,75},{-96,-44},{-19,66},{21,84},{-56,-64},{39,-15},{0,45},{-81,-54},{-66,-93},{-4,2},{-42,-67},{-15,-33},{1,-32},{-74,-24},{7,18},{-62,84},{19,61},{39,79},{60,-98},{-76,45},{58,-98},{33,26},{-74,-95},{22,30},{-68,-62},{-59,4},{-62,35},{-78,80},{-82,54},{-42,81},{56,-15},{32,-19},{34,93},{57,-100},{-1,-87},{68,-26},{18,86},{-55,-19},{-68,-99},{-9,47},{24,94},{92,97},{5,67},{97,-71},{63,-57},{-52,-14},{-86,-78},{-17,92},{-61,-83},{-84,-10},{20,13},{-68,-47},{7,28},{66,89},{-41,-17},{-14,-46},{-72,-91},{4,52},{-17,-59},{-85,-46},{-94,-23},{-48,-3},{-64,-37},{2,26},{76,88},{-8,-46},{-19,-68}};
        System.out.println(robotSim(commands, obstacles));
        System.out.println(robotSim1(commands, obstacles));
    }

    /**
     * 模拟前进. 注意: 题目要求的是每次走完之后求一次值. 保留最大的一个返回. 不是最终位置
     * */
    private static int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int f = 0;
        int[] start = {0, 0};
        for (int command : commands) {
            if (command < 0) {
                if (command == -1) {
                    if (f == 270) {
                        f = 0;
                    } else {
                        f += 90;
                    }
                }
                if (command == -2) {
                    if (f == 0) {
                        f = 270;
                    } else {
                        f -= 90;
                    }
                }
            } else {
                if (f == 0) {
                    for (int j = 0; j < command; j++) {
                        if (!check(start, f, obstacles)) {
                            break;
                        }
                        start[1]++;
                    }
                }
                if (f == 90) {
                    for (int j = 0; j < command; j++) {
                        if (!check(start, f, obstacles)) {
                            break;
                        }
                        start[0]++;
                    }
                }
                if (f == 180) {
                    for (int j = 0; j < command; j++) {
                        if (!check(start, f, obstacles)) {
                            break;
                        }
                        start[1]--;
                    }
                }
                if (f == 270) {
                    for (int j = 0; j < command; j++) {
                        if (!check(start, f, obstacles)) {
                            break;
                        }
                        start[0]--;
                    }
                }
                max = Math.max(Math.abs(start[0] * start[0]) + Math.abs(start[1] * start[1]), max);
            }
        }
        return max;
    }
    private static boolean check(int[] start, int f, int[][] obstacles) {
        int x = start[0];
        int y = start[1];
        if (f == 0) {
            for (int[] ob : obstacles) {
                if (ob[0] == x) {
                   if (y + 1 == ob[1]) {
                       // 撞到障碍物
                       return false;
                   }
                }
            }
        }
        if (f == 90) {
            for (int[] ob : obstacles) {
                if (ob[1] == y) {
                    if (x + 1 == ob[0]) {
                        // 撞到障碍物
                        return false;
                    }
                }
            }
        }
        if (f == 180) {
            for (int[] ob : obstacles) {
                if (ob[0] == x) {
                    if (y - 1 == ob[1]) {
                        // 撞到障碍物
                        return false;
                    }
                }
            }
        }
        if (f == 270) {
            for (int[] ob : obstacles) {
                if (ob[1] == y) {
                    if (x - 1 == ob[0]) {
                        // 撞到障碍物
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 优化题解
     * 将障碍物坐标进行hash运算放入集合.
     * 每次前进时, 走了一步后的hash值如果在集合中, 就表示走到了障碍物上. 此步作废
     * */
    private static int robotSim1(int[] commands, int[][] obstacles) {
        // 预定义各个方向前进一步的值. 为了后边根据方向变量来取值
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        // 保存最大欧式距离
        int max = 0;
        // 标记方向 0 上 1右 2下 3左
        int f = 0;
        int x = 0;
        int y = 0;
        // 将障碍物坐标进行hash运算放入集合中
        Set<Long> set = new HashSet<>();
        for (int[] ob : obstacles) {
            long ox = (long) ob[0] + 30000L;
            long oy = (long) ob[1] + 30000L;
            set.add((ox << 16) + oy);
        }
        for (int command : commands) {
            if (command == -2) {
                // 左转
                f = (f + 3) % 4;
            } else if (command == -1) {
                // 右转
                f = (f + 1) % 4;
            } else {
                // 前进
                for (int i = 0; i < command; i++) {
                    int xx = x + dx[f];
                    int yy = y + dy[f];
                    long hashCode = (((long) xx + 30000L) << 16) + ((long) yy + 30000L);
                    // 未碰到障碍物
                    if (!set.contains(hashCode)) {
                        x = xx;
                        y = yy;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }
        return max;
    }
}
