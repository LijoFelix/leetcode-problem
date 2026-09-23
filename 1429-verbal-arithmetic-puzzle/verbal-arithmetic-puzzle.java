class Solution {
    int[] map = new int[26];
    boolean[] used = new boolean[10];
    boolean[] nonZero = new boolean[26];
    String[] words;
    String result;

    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        java.util.Arrays.fill(map, -1);
        int maxLen = result.length();

        for (String word : words) {
            if (word.length() > maxLen) return false;
            if (word.length() > 1)
                nonZero[word.charAt(0) - 'A'] = true;
        }

        if (result.length() > 1)
            nonZero[result.charAt(0) - 'A'] = true;

        return solve(0, 0);
    }

    boolean solve(int col, int carry) {
        if (col == result.length())
            return carry == 0;
        return addWords(col, 0, carry);
    }

    boolean addWords(int col, int index, int sum) {
        if (index == words.length) {
            int digit = sum % 10;
            int carry = sum / 10;
            int pos = result.length() - 1 - col;
            int ch = result.charAt(pos) - 'A';

            if (map[ch] != -1) {
                if (map[ch] != digit) return false;
                return solve(col + 1, carry);
            }

            if (used[digit]) return false;
            if (digit == 0 && nonZero[ch]) return false;

            map[ch] = digit;
            used[digit] = true;
            boolean found = solve(col + 1, carry);
            map[ch] = -1;
            used[digit] = false;
            return found;
        }

        String word = words[index];
        int pos = word.length() - 1 - col;

        if (pos < 0)
            return addWords(col, index + 1, sum);

        int ch = word.charAt(pos) - 'A';

        if (map[ch] != -1)
            return addWords(col, index + 1, sum + map[ch]);

        for (int d = 0; d <= 9; d++) {
            if (used[d]) continue;
            if (d == 0 && nonZero[ch]) continue;

            map[ch] = d;
            used[d] = true;

            if (addWords(col, index + 1, sum + d))
                return true;

            map[ch] = -1;
            used[d] = false;
        }

        return false;
    }
}