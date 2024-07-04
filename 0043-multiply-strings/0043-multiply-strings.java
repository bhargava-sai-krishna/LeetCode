import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
        BigInteger product =new BigInteger(num1).multiply(new BigInteger(num2));
        return product.toString();
    }
}