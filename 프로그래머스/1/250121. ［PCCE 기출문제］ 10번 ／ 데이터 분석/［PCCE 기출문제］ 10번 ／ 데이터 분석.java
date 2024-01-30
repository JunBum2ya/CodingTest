import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = Arrays.stream(data)
            .filter(array -> array[Column.convertNameToIndex(ext)] < val_ext)
            .sorted((val, contrast) -> val[Column.convertNameToIndex(sort_by)] > contrast[Column.convertNameToIndex(sort_by)] ? 1 : -1)
            .collect(Collectors.toList());
        int[][] answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    enum Column {
        CODE(0, "code"),DATE(1, "date"),MAXIMUM(2, "maximum"),REMAIN(3, "remain");
        
        private final int index;
        private final String name;
        
        Column(int index, String name) {
            this.index = index;
            this.name = name;
        }
        
        public static int convertNameToIndex(String name) {
            return Arrays.stream(Column.values())
                .filter(column -> column.name.equals(name))
                .map(column -> column.index)
                .findFirst()
                .orElse(-1);
        }
        
    }
    
}