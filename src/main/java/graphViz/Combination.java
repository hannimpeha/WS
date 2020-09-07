package graphViz;

import java.util.Arrays;

public class Combination {

    public static void main(String[] args){
        String[] arr = {"hyo","ji","yoo","mi","se","ari"};
        combination(arr, 2, 0, new String[2]);
    }


    public static void combination(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combination(arr, len-1, i+1, result);
        }
    }
}
