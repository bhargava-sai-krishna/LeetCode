class Solution {
    public double calculateGain(int passes, int totalStudents){
        return ((double)(passes+1)/(totalStudents+1)-(double)passes/totalStudents);
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]>heap=new PriorityQueue<>((a, b)->Double.compare(b[0], a[0]));
        for(int[] clas:classes){
            heap.offer(new double[] {calculateGain(clas[0], clas[1]), clas[0], clas[1]});
        }
        while(extraStudents-->0){
            double[] curr=heap.poll();
            heap.offer(new double[]{calculateGain((int)curr[1]+1, (int)curr[2]+1), (int)curr[1]+1, (int)curr[2]+1});
        }
        double totalPassRatio=0;
        while(!heap.isEmpty()){
            double[] curr=heap.poll();
            int pass=(int)curr[1];
            int totalStudents=(int)curr[2];
            totalPassRatio+=(double) pass/totalStudents;
        }
        return totalPassRatio/classes.length;
    }
}