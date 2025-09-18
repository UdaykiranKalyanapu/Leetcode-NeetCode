package Tem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Taskmanager {
        private Map<Integer, int[]> taskMap; // taskId -> [userId, priority]
        private PriorityQueue<int[]> maxHeap; // (-priority, -taskId, userId)

        public void TaskManager(List<List<Integer>> tasks) {
            taskMap = new HashMap<>();
            maxHeap = new PriorityQueue<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // higher priority first (because we store -priority)
                return a[1] - b[1]; // higher taskId first (because we store -taskId)
            });

            for (List<Integer> t : tasks) {
                add(t.get(0), t.get(1), t.get(2));
            }
        }

        public void add(int userId, int taskId, int priority) {
            taskMap.put(taskId, new int[]{userId, priority});
            maxHeap.offer(new int[]{-priority, -taskId, userId});
        }

        public void edit(int taskId, int newPriority) {
            int userId = taskMap.get(taskId)[0];
            taskMap.put(taskId, new int[]{userId, newPriority});
            maxHeap.offer(new int[]{-newPriority, -taskId, userId});
        }

        public void rmv(int taskId) {
            taskMap.remove(taskId); // lazy delete; heap entries become stale
        }

        public int execTop() {
            while (!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                int priority = -top[0];
                int taskId = -top[1];
                int heapUser = top[2];

                int[] cur = taskMap.get(taskId);
                // Validate both current priority and userId match the heap entry
                if (cur != null && cur[0] == heapUser && cur[1] == priority) {
                    taskMap.remove(taskId);
                    return heapUser;
                }
                // otherwise stale entry — keep popping
            }
            return -1;
        }
    }

