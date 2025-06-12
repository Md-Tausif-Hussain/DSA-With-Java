public class SAPLabs2 {
    // This method takes two strings and merges them by alternating characters from each string.
    public static String appendStrings(String s1, String s2) {
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        // Find the length of the shorter string
        int minLength = Math.min(s1.length(), s2.length());
        // Loop through both strings up to the length of the shorter string
        for (int i = 0; i < minLength; i++) {
            // Append one character from s1
            result.append(s1.charAt(i));
            // Append one character from s2
            result.append(s2.charAt(i));
        }
        // If s1 is longer, append the remaining characters of s1
        if (s1.length() > minLength) {
            result.append(s1.substring(minLength));
        }
        // If s2 is longer, append the remaining characters of s2
        else if (s2.length() > minLength) {
            result.append(s2.substring(minLength));
        }
        // Convert the StringBuilder to a String and return it
        return result.toString();
    }
    public static void main(String[] args) {
        String s1 = "van";
        String s2 = "maggi";
        System.out.println(appendStrings(s1, s2)); // Output should be "vmaanggi"
    }
}
