class Solution {
    public List<String> fizzBuzz(int n) {
        int count=1;
        String[] a=new String[n];
        for(int i=0;i<n;i++)
        {
            if(count%3==0 && count%5==0)
            {
                a[i]="FizzBuzz";
            }
            else if(count%3==0)
            {
                a[i]="Fizz";
            }
            else if(count%5==0)
            {
                a[i]="Buzz";
            }
            else
            {
                a[i]=Integer.toString(count);
            }
            count++;
        }
        return Arrays.asList(a);
    }
}