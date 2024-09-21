function solution(my_string, is_suffix) {
    const test = my_string.substring(my_string.length - is_suffix.length, my_string.length);
    return test === is_suffix ? 1 : 0;
}