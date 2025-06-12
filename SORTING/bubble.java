public class bubble {
        // Method to perform Bubble Sort
        public static void bubbleSort(int[] a, int n) {
            int i, round, temp;
            for (round = 1; round < n; round++) {
                boolean flag = false;
                for (i = 0; i <n-round; i++) {
                    if (a[i] > a[i + 1]) {
                        flag = true;
                        temp = a[i];
                        a[i] = a[i+1];
                        a[i+1] = temp;
                    }
                }
                // If no elements were swapped in the inner loop, then the array is already sorted
                if (!flag) {
                    System.out.println("Round = " + round);
                    break;
                }
            }
        }
        // Method to print the array
        public static void printArray(int[] arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    
        // Main method to test the bubble sort algorithm
        public static void main(String[] args) {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            int n = arr.length;
    
            System.out.println("Unsorted array:");
            printArray(arr);
    
            bubbleSort(arr, n);
    
            System.out.println("Sorted array:");
            printArray(arr);
        }
    }
        

