function fibonacci(num: number): number {
    if (num < 0) {
        return -1;
    }
    if (num == 0 || num == 1) {
        return num;
    }
    return fibonacci(num - 1) + fibonacci(num - 2)
}

console.log("day so fibonacci dau tien")
for (let i = 0; i < 10; i++) {
    console.log(fibonacci(i))
}

let sum: number = 0;
console.log("tong 10 so fibonacci dau tien")
for (let i = 0; i < 10; i++) {
    sum += fibonacci(i)
}
console.log(sum)