import java.util.Random;

public class Grid {
    public static boolean gridEquals(int[][] arr1, int[][] arr2){
        int bigger;
        if (arr1.length>=arr2.length){
            bigger = arr1.length;
        }
        else{
            bigger = arr2.length;
        }
        for(int i = 0; i < bigger; i++){
            for(int k = 0; k < bigger; k++){
                if (arr1[i][k] != arr2[i][k]){
                    return false;
                }
            }
        }
        return true;

    }

    public static int[][] rotate(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = arr[i][j];
            }
        }
        return result;
    }


    public static void main(String[] args){
        String[][] grid;
        grid = new String[3][5];

        grid = new String[3][]; 
        for(int i = 0; i < 3; i++){
            grid[i] = new String[i+3];
        } 

        for(int j = 0; j < grid.length; j++){
            for(int k = 0; k < grid[j].length; k++){

                Random ran = new Random();
                int ascii = ran.nextInt(25);
                ascii += 65;

                char letter = (char) ascii;

                grid[j][k] = new String("" + letter);

                System.out.println(grid[j][k]);
            }
        }


        int[][] arr1 = new int[2][2];
        int[][] arr2 = new int[2][2];
        int[][] arr3;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                arr1[i][j] = i+j;
                arr2[i][j] = i+j;
            }
        } 
        arr3 = arr1;
        // System.out.println(gridEquals(arr1, arr2));
        // System.out.println(gridEquals(arr1, arr3));


        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result = rotate(arr);

    for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[0].length; j++) {
            System.out.print(result[i][j] + " ");
            }
        System.out.println();
        }
    }
}
