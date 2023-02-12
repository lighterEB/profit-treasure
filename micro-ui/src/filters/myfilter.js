// 保留2位小数不四舍五入
export function numFilter (num) {
    let tempVal = parseFloat(num).toFixed(3);
    let realVal = tempVal.substring(0, tempVal.length - 1);
    return realVal;
}