/*
//Exceeds time limit. DFS
public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        List<Integer> sumResult = new ArrayList<>();
        helper(triangle, 0, 0, 0, sumResult);
        return Collections.min(sumResult);
        
    }
    
    public void helper(List<List<Integer>> triangle, int level, int index, int sum, List<Integer> sumResult){
        if(level >= triangle.size()){
            sumResult.add(sum);
            return;
        }
        List<Integer> curLevel = triangle.get(level);
        for(int i = index; i <= index+1; i++){
            if(i < 0 || i >= curLevel.size()) continue;
            sum += curLevel.get(i);
            helper(triangle, level+1, i, sum, sumResult);
            sum -= curLevel.get(i);
        }    
        
    }*/
    
    //Dp
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        List<Integer> lastRow = triangle.get(triangle.size()-1);
        int[][] sum = new int[triangle.size()][lastRow.size()];
        //fill in last row.
        for(int i = 0; i < lastRow.size(); i++){
            sum[sum.length - 1][i] = lastRow.get(i);
        }
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                sum[i][j] = triangle.get(i).get(j) + Math.min(sum[i+1][j], sum[i+1][j+1]);
            }
        }
        return sum[0][0];
        
    }