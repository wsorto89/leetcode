/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.list = [];
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if(!this.cache.has(key)) {
        return -1;
    } else {
        this.update(key);
        return this.cache.get(key);
    }
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if(this.cache.has(key)) {
        this.update(key);
    } else {
        this.list.push(key);
    }
    this.cache.set(key, value);
    if(this.cache.size > this.capacity) {
        const lastNode = this.list.shift();
        this.cache.delete(lastNode);
    }
};

LRUCache.prototype.update = function(key) {
    let index = this.list.indexOf(key);
    this.list.splice(index, 1);
    this.list.push(key);
}

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = Object.create(LRUCache).createNew(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
