function solution(code) {
    var answer = '';
    let mode = false;
    for(let idx in code) {
        const c = code[idx];
        if(c === '1') {
            mode = !mode;
        }else {
            if(idx % 2 === 0 && !mode) {
                answer += c;
            }
            if(idx % 2 === 1 && mode) {
                answer += c;
            }
        }
    }
    if(!answer) {
        return "EMPTY";
    }
    return answer;
}