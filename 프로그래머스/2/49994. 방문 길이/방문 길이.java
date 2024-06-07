import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            if(c == 'U') {
                if(y + 1 <= 5) {
                    set.add(x + " " + y + " " + x + " " + (y + 1));
                    set.add(x + " " + (y + 1) + " " + x + " " + y);
                    y++;
                }
            }else if(c == 'D') {
                if(y - 1 >= -5) {
                    set.add(x + " " + y + " " + x + " " + (y - 1));
                    set.add(x + " " + (y - 1) + " " + x + " " + y);
                    y--;
                }
            }else if(c == 'R') {
                if(x + 1 <= 5) {
                    set.add(x + " " + y + " " + (x + 1) + " " + y);
                    set.add((x + 1) + " " + y + " " + x + " " + y);
                    x++;
                }
            }else if(c == 'L') {
                if(x - 1 >= -5) {
                    set.add(x + " " + y + " " + (x - 1) + " " + y);
                    set.add((x - 1) + " " + y + " " + x + " " + y);
                    x--;
                }
            }
        }
        return set.size() / 2;
    }
}