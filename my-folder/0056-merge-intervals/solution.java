/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        
        if(intervals.size() < 1) {
            return result;
        }
        
        intervals.sort(Comparator.comparingInt(o -> o.start));
        
        result.add(intervals.get(0));
        int prevStart = intervals.get(0).start;
        int prevEnd = intervals.get(0).end;
        int curResultIndex = 0;
        
        for(int i = 1; i < intervals.size(); i++) {
            Interval prev = result.get(curResultIndex);
            Interval current = intervals.get(i);
            
            if(prev.end < current.start) {
                result.add(current);
                curResultIndex++;
            } else {
                prev.end = Math.max(prev.end, current.end);
            }
            /*if(current.start <= prev.start && current.end <= prev.end) {
                if(result.size() > 0) {
                    result.remove(curResultIndex);
                    curResultIndex--;
                }
                result.add(new Interval(current.start, prev.end));
            } else if(current.start <= prev.end && current.end <= prev.end) {
                if(result.size() > 0) {
                    result.remove(curResultIndex);
                    curResultIndex--;
                }
                result.add(new Interval(prev.start, prev.end));
            } else if(current.start <= prev.end) {
                if(result.size() > 0) {
                    result.remove(curResultIndex);
                    curResultIndex--;
                }
                result.add(new Interval(Math.min(prev.start, current.start), current.end));
            } else {
                result.add(current);
            }
            curResultIndex++;*/
        }
        
        return result;
    }
}
