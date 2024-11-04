package P1942;

import java.util.*;
class Solution {
    
    private class Event {
        int index;
        int chair = -1;
        int startTime;
        int endTime;

        public Event(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void setChair(int chair) {
            this.chair = chair;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        Event[] arrival = new Event[times.length];

        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<Event> assigned = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);

        for (int i = 0; i < times.length; i++) {
            arrival[i] = new Event(i, times[i][0], times[i][1]);
            available.add(i);
        }

        Arrays.sort(arrival, (a, b) -> a.startTime - b.startTime);

        for (int i = 0; i < arrival.length; i++) {
            Event event = arrival[i];
            while (!assigned.isEmpty() && assigned.peek().endTime <= event.startTime) {
                available.add(assigned.poll().chair);
            }

            event.setChair(available.poll());
            assigned.add(event);

            if (event.index == targetFriend) {
                return event.chair;
            }
        }

        return -1;
    }
}