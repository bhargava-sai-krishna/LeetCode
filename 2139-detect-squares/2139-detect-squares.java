class PointAndCount{
    public int val,count;
    PointAndCount(int val,int count){
        this.val=val;
        this.count=count;
    }
}

class DetectSquares {
    private HashMap<Pair<Integer,Integer>,Integer> pointmap;
    private HashMap<Integer,List<PointAndCount>> mapx;
    
    public DetectSquares() {
        pointmap = new HashMap<Pair<Integer,Integer>,Integer>();
        mapx = new HashMap<Integer,List<PointAndCount>>();
    }
    
    public void add(int[] point) {
        Pair<Integer,Integer> pair = new Pair<>(point[0],point[1]);
        pointmap.put(pair,pointmap.getOrDefault(pair,0)+1);
        addValuesToMaps(mapx,point);
    }
    
    private void addValuesToMaps(HashMap<Integer,List<PointAndCount>> map,int[] point){
        List<PointAndCount> lis = map.getOrDefault(point[0],new ArrayList<PointAndCount>());
        int count=0;
        PointAndCount y=null;
        if(lis.size()==0){
            lis.add(new PointAndCount(point[1],1));
            map.put(point[0],lis);
        }else{
            for(PointAndCount ob : lis){
                if(ob.val==point[1]){
                    y=ob;
                    break;
                }
            }
            if(y==null){
                y=new PointAndCount(point[1],1);
                lis.add(y);
            }else
                y.count++;
        }   
    }
    
    public int count(int[] point) {
        int res=0;
        List<PointAndCount> lis = mapx.getOrDefault(point[0],new ArrayList<PointAndCount>());
        for(PointAndCount ob : lis){
            Pair<Integer,Integer> pointa=new Pair<>(ob.val-point[1]+point[0],point[1]);
            Pair<Integer,Integer> pointb=new Pair<>(ob.val-point[1]+point[0],ob.val);
            
            Pair<Integer,Integer> pointc=new Pair<>(-(ob.val-point[1])+point[0],point[1]);
            Pair<Integer,Integer> pointd=new Pair<>(-(ob.val-point[1])+point[0],ob.val);
            
            if((ob.val-point[1])!=0){
                res+=pointmap.getOrDefault(pointa,0)*pointmap.getOrDefault(pointb,0)*ob.count;
                res+=pointmap.getOrDefault(pointc,0)*pointmap.getOrDefault(pointd,0)*ob.count;
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */