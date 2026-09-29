class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastPosition = new int[26];
        boolean[] used = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            lastPosition[s.charAt(i) - 'a'] = i;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (used[ch - 'a']) {
                continue;
            }

            while (result.length() > 0) {

                char last = result.charAt(result.length() - 1);

                if (last <= ch) {
                    break;
                }

                if (lastPosition[last - 'a'] <= i) {
                    break;
                }

                used[last - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            result.append(ch);
            used[ch - 'a'] = true;
        }

        return result.toString();
    }
}
