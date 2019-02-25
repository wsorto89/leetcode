/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let sum = 0;
    
    if(grid === null || grid.length === 0) {
        return 0;
    }
    for(let i = 0; i < grid.length; i++) {
        for(let j = 0; j < grid[i].length; j++) {
            if(grid[i][j] === "1") {
                sum++;
                dfs(grid, i, j);
            }
        }
    }
    
    return sum;
};

const dfs = function(grid, r, c) {
    maxR = grid.length - 1;
    maxC = grid[0].length - 1;
    if(r < 0 || c < 0 || r > maxR || c > maxC || grid[r][c] === "0") {
        return false;
    }
    grid[r][c] = "0";
    dfs(grid, r-1, c);
    dfs(grid, r+1, c);
    dfs(grid, r, c-1);
    dfs(grid, r, c+1);
}
    
var accountYourNeighbors = function(grid, account, i, j) {
    if(i === grid.length - 1) {
        if(j !== grid[i].length - 1) {
            if(grid[i][j+1] === "1") {
                account[i][j+1] = true;
            }
        }
    }
    else if(j === grid[i].length - 1) {
        if(grid[i+1][j] === "1") {
           account[i+1][j] = true;
        }
    }
    else {
        if(grid[i+1][j] === "1") {
            account[i+1][j] = true;
        }
        if(grid[i][j+1] === "1") {
            account[i][j+1] = true;
        }
    }
}
