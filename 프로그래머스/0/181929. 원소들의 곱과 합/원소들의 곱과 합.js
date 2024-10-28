function solution(num_list) {
    let a = 1;
    let b = 0;
    num_list.forEach((item, index) => {
        a = a * item;
        b = b + item;
    });
    return a < (b * b) ? 1 : 0;
}