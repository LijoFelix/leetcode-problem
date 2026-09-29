class Solution {
    public String removeDuplicateLetters(String s) {

        // Stores the last position of each character
        int[] lastPosition = new int[26];

        // Tells whether a character is already in result
        boolean[] used = new boolean[26];

        // Find last position of every character
        for (int i = 0; i < s.length(); i++) {
            lastPosition[s.charAt(i) - 'a'] = i;
        }

        StringBuilder result = new StringBuilder();

        // Process each character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Already present in result → skip
            if (used[ch - 'a']) {
                continue;
            }

            // Check whether we can remove characters from result
            while (result.length() > 0) {

                char last = result.charAt(result.length() - 1);

                // Last character is already smaller
                if (last <= ch) {
                    break;
                }

                // Last character will not appear again
                if (lastPosition[last - 'a'] <= i) {
                    break;
                }

                // Remove last character
                used[last - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            // Add current character
            result.append(ch);
            used[ch - 'a'] = true;
        }

        return result.toString();
    }
}



// Current character
//        ↓
// Already used?
//    YES → skip
//    NO
//        ↓
// Check last character
//        ↓
// Last > current?
//    NO → add current
//    YES
//        ↓
// Last comes again later?
//    NO → keep last
//    YES
//        ↓
// Remove last
//        ↓
// Check agai