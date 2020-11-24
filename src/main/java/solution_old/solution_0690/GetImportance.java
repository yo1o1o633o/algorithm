package solution_old.solution_0690;

import entity.Employee;

import java.util.*;

/**
 * @author shuai.yang
 */
public class GetImportance {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance = 5;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        employee.subordinates = list;

        Employee employee1 = new Employee();
        employee1.id = 2;
        employee1.importance = 3;

        Employee employee2 = new Employee();
        employee2.id = 3;
        employee2.importance = 3;

        List<Employee> list1 = new ArrayList<>();
        list1.add(employee);
        list1.add(employee1);
        list1.add(employee2);
        int id = 1;

        System.out.println(getImportance(list1, id));
    }

    /**
     * 广度搜索, 统计重要度的总和
     * */
    private static int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }
        // 用Map将所有的员工存起来, 避免再去循环查找
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll != null) {
                    Employee employee = map.get(poll);
                    sum += employee.importance;
                    if (employee.subordinates == null || employee.subordinates.size() == 0) {
                        break;
                    }
                    queue.addAll(employee.subordinates);
                }
            }
        }
        return sum;
    }
}
