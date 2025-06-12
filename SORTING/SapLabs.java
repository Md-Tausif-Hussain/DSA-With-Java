import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SapLabs {
    public static void solution(int n, String st[], int k, int range[][]) {
        int ar[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            String word = st[i];
            if (isVowel(word.charAt(0)) || isVowel(word.charAt(word.length() - 1))) {
                // Checking if the first or last character is a vowel
                ar[i + 1] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            ar[i] = ar[i - 1] + ar[i]; // Cumulative sum
        }
        for (int i = 0; i < k; i++) {
            int a = range[i][0];
            int b = range[i][1];
            System.out.println(ar[b] - ar[a - 1]);
        }
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c); // Handle both uppercase and lowercase vowels
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String st[] = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        int range[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            String s[] = br.readLine().split(" ");
            range[i][0] = Integer.parseInt(s[0]);
            range[i][1] = Integer.parseInt(s[1]);
        }
        solution(n, st, k, range);
    }
}
