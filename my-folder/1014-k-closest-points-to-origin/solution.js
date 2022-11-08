/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number[][]}
 */
var kClosest = function(points, k) {
    const data = points.map(([x, y]) => ({
        dist: calcDistance(x, y),
        points: [x, y]
    }));
    data.sort((a, b) => { return a.dist - b.dist});
    return data.slice(0, k).map(d => d.points)
};

var calcDistance = function(x, y) {
    return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))
}

