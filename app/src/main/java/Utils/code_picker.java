package Utils;

import java.util.Random;

public class code_picker {
    int current_color = 0;
    String[] Code = {"C 1000", "C 1001", "C 1002", "C 1003", "C 1004", "C 1005"};

    public String get_code(){
        Random rand = new Random();
        current_color = rand.nextInt(Code.length-1);
        return Code[current_color];
    }
}
