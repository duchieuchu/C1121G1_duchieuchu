function checkFibonacci(num: number): number {
    if (num < 0) {
        return -1;
    }
    if (num == 0 || num == 1) {
        return num;
    }
    return checkFibonacci(num - 1) + checkFibonacci(num - 2)
}

console.log("day so fibonacci dau tien")
for (let i = 0; i < 10; i++) {
    console.log(checkFibonacci(i))
}

let sum: number = 0;
console.log("tong 10 so fibonacci dau tien")
for (let i = 0; i < 10; i++) {
    sum += checkFibonacci(i)
}
console.log(sum)
