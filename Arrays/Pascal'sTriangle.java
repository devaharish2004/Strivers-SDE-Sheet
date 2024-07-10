import java.util.*;
class Solution {
    public List<Integer> generateRows(int rowNum) {
        List<Integer> rowList = new ArrayList<>();
        int result = 1;
        rowList.add(result);
        for(int col = 1; col < rowNum; col++){
            result = result * (rowNum-col);
            result = result / col;
            rowList.add(result);
        }
        return rowList;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            list.add(generateRows(i));
        }
        return list;
    }
}