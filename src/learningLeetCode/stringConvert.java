package learningLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class stringConvert {
    /*
    * Time Complexity is O(N) where n == len(s)
    * Space Complexity is O(N)
    * */
    static public String convert(String s, int numRows) {
        if (numRows ==1) return s;
        ArrayList<StringBuilder> arrayList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            arrayList.add(new StringBuilder());
        }
        int row = 0;
        boolean goingDown = true;
        for (char c : s.toCharArray()) {
            var stringBuilder = arrayList.get(row);
            stringBuilder.append(c);
            if (goingDown){
                row+=1;
                if (row ==numRows){
                    row-=2;
                    goingDown= !goingDown;
                }
            }else {
                row-=1;
                if (row == -1){
                    row+= 2;
                    goingDown= !goingDown;
                }
            }
        }
        var result = new StringBuilder();
        for (StringBuilder stringBuilder:arrayList) {
            result.append(stringBuilder);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringConvert.convert("PAYPALISHIRING", 3));

    }
}
