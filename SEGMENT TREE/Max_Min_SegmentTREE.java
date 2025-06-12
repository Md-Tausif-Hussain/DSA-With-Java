import java.util.*;

public class Max_Min_SegmentTREE{
    static int tree[];

    public static void init(int n){
       tree = new int[4*n];
    }

    
    public static void buildIST(int i, int si, int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return ;
        }
        int mid = (si+sj)/2;
        buildIST(2*i+1,si,mid,arr);//Left Subtree
        buildIST(2*i+2,mid+1,sj,arr);//Right Subtree
        tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
    }

    public static int getMaxUTIL(int i, int si, int sj,int qi, int qj){
        if(si> qj || sj<qi){//Non Overlapping
           return Integer.MIN_VALUE;
        }
        else if(si>=qi && sj<=qj){//Complete Overlap
           return tree[i];
        }
        else{//partial overlap
           int mid = (si+sj)/2;
           int left = getMaxUTIL(2*i+1, si, mid, qi, qj);
           int right = getMaxUTIL(2*i+2,mid+1, sj, qi, qj);
           return Math.max(left, right);
        }
    }
    public static int getMAX(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUTIL(0,0,n-1,qi,qj);
    }


    public static void UpdateUtil(int i, int si, int sj, int idx, int newVal){
        if(idx < si || idx > sj){
           return;
        }

        tree[i] = Math.max(tree[i], newVal);

        if(si != sj){//Non -Leaf
            int mid = (si+sj)/2;
            UpdateUtil(2*i+1, si,mid, idx,newVal);//left
            UpdateUtil(2*i+2,mid+1, sj, idx,newVal);//right
        }
    }

    public static void Update(int arr[], int idx, int newVal){
        int n = arr.length;
        arr[idx] = newVal;
        UpdateUtil(0,0,n-1,idx,newVal);//Segment tree Updation
    }

    public static void main(String[] args) {
      int arr[] = {6,8,-1,2,17,1,3,2,4};
      int n = arr.length;
      init(n);
      buildIST(0, 0, n-1, arr);

      for(int i=0; i<tree.length; i++){
        System.out.print(tree[i]+" ");
      }
      System.out.println();
      int max = getMAX(arr, 2, 5);
      System.out.println(max);

      Update(arr,2,20);
      System.out.println(getMAX(arr, 2, 5));
    }
}
