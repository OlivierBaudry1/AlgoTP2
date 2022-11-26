public class Levenshtein {

    public static int distance(String str1, String str2) {
        int n = str1.length()+1;
        int m = str2.length()+1;
        int[][] values = new int[n][m];

        for (int i = 0; i < n; i++ ){
            values[i][0] = i;
        }

        for (int j = 0; j < m; j ++){
            values[0][j] = j;
        }

        for(int j = 1; j < m; j++ ){
            for (int i = 1; i < n; i++){
                char last_w = str1.charAt(i-1);
                char last_u = str2.charAt(j-1);

                if(last_w == last_u){
                    values[i][j] = values[i-1][j-1];

                } else{
                    values[i][j] = 1 + Math.min(Math.min(values[i-1][j-1],values[i-1][j]), values[i][j-1]);

                }
            }
        }
        return values[n-1][m-1];
    }

}
