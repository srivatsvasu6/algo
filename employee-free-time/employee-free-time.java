/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
       List result = new ArrayList<>();

        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
        schedule.forEach(e -> queue.addAll(e));
        int end = queue.poll().end;
        while(!queue.isEmpty()) {
            if(end < queue.peek().start) {
                Interval interval = queue.poll();
                result.add(new Interval(end, interval.start));
                end = interval.end;
            }else {
                end = Math.max(end, queue.poll().end);
            }
        }
        return result;
            
    }
}