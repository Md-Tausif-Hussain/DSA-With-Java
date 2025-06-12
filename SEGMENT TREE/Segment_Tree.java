import java.util.*;

public class Segment_Tree {
    static int tree[];

    public static void init(int n){
       tree = new int[4*n];
    }

    public static int buildIST(int arr[], int i, int start, int end){
            if(start == end){
                tree[i] = arr[start];
                return arr[start];
            }
            int mid = (start + end)/2;
            buildIST(arr, 2*i+1, start, mid);//Left Subtree
            buildIST(arr,2*i+2,mid+1, end);//Right Subtree
            tree[i] = tree[2*i+1] + tree[2*i+2];
            return tree[i];

    }

    public static int getSumUTIL(int i, int si, int sj,int qi, int qj){
        if(qj<=si || qi>=sj){//Non Overlapping
           return 0;
        }
        else if(si>=qi && sj<=qj){//Complete Overlap
           return tree[i];
        }
        else{//partial overlap
           int mid = (si+sj)/2;
           int left = getSumUTIL(2*i+1, si, mid, qi, qj);
           int right = getSumUTIL(2*i+2,mid+1, sj, qi, qj);
           return left+right;
        }
    }
    public static int getSum(int arr[], int qi, int qj){
        int n = arr.length;
        return getSumUTIL(0,0,n-1,qi,qj);
    }

    public static void UpdateUtil(int i, int si, int sj, int idx, int diff){
        if(idx > sj || idx < si){
           return;
        }

        tree[i] += diff;

        if(si != sj){//Non -Leaf
            int mid = (si+sj)/2;
            UpdateUtil(2*i+1, si,mid, idx, diff);//left
            UpdateUtil(2*i+2,mid+1, sj, idx, diff);//right
        }
    }

    public static void Update(int arr[], int idx, int newVal){
        int n = arr.length;
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        UpdateUtil(0,0,n-1,idx,diff);//Segment tree Updation
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildIST(arr,0,0,n-1);

           for(int i=0; i<tree.length; i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getSum(arr,2,5));//18
        Update(arr,2,2);
        System.out.println(getSum(arr,2,5));//17
    }
}
