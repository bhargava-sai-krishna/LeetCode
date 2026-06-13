class Solution {
    private int getWeight(String word, int[] weights) {
        int weight = 0;

        for(char c : word.toCharArray()) {
            weight += weights[c - 'a'];
        }

        return weight;
    }

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        
        for(String word : words) {
            int weight = getWeight(word, weights);
            sb.append((char)('z' - (weight % 26)));
        }

        return sb.toString();
    }
}