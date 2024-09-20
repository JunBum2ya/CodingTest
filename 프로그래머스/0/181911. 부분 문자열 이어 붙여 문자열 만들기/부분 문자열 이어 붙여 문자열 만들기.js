function solution(my_strings, parts) {
    var answer = '';
    parts.forEach((item, index) => {
        const my_string = my_strings[index];
        answer = answer.concat(my_string.substring(item[0],item[1] + 1));
    });
    return answer;
}