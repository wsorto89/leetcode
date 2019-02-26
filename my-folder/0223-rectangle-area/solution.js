/**
 * @param {number} A
 * @param {number} B
 * @param {number} C
 * @param {number} D
 * @param {number} E
 * @param {number} F
 * @param {number} G
 * @param {number} H
 * @return {number}
 */
var computeArea = function(A, B, C, D, E, F, G, H) {
    let totalArea = 0;
    const area1 = computeSingleRectArea(A, B, C, D);
    const area2 = computeSingleRectArea(E, F, G, H);
    
    totalArea = area1 + area2;
    const commonWidth = intersection(A, C, E, G);
    const commonHeight = intersection(B, D, F, H);
    const commonArea = commonWidth * commonHeight;
    return totalArea - commonArea;
};

var computeSingleRectArea = function(A, B, C, D) {
    const width = Math.abs(A - C);
    const height = Math.abs(B - D);
    
    return width * height;
}

var intersection = function(start1, end1, start2, end2) {
    if(end1 <= start2 || end2 <= start1) {
       return 0;
    } else {
        if(start2 <= start1 && end1 <= end2) {
            return end1 - start1;
        }
        else if(start1 <= start2 && end2 <= end1) {
            return end2 - start2;
        }
        else if(start1 <= start2) {
            return end1 - start2;
        }
        else if(start2 <= start1) {
            return end2 - start1;
        }
    }
}
