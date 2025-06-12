public class Recursive_Key {

    public static int power(int x, int n){

      if(n == 0){
        return 1;
      }

      return x * power(x , n-1);

    }

    public static int optimizedPower(int a , int n){
        if(n == 0){
            return 1;
          }
            int halfPower = optimizedPower(a, n/2);
          int halfPowerSq =  halfPower * halfPower;

          //n is odd
          if(n % 2 != 0){
            halfPowerSq = a * halfPowerSq;
          }

          return halfPowerSq;
    
    }

    public static int firstoccurance(int a[], int key , int i){
        if(i == a.length){
            return -1;
        }

        if(a[i] == key){
            return i;
        }
       return  firstoccurance(a, key, i+1);
    }

    public static int lastoccurrance(int a[] , int key , int i){
        if(i == a.length){
            return -1;
        }

        int isfound = lastoccurrance(a, key, i+1);
        
        if(isfound == -1 && a[i] == key){
            return i;
        }

        return isfound;

    }

    public static void main(String[] args) {
        int a[] = {1,4,3,9,8,5,4,7,8};


        System.out.println(optimizedPower(2, 10));

        System.out.print(power(2, 10));

        System.out.print("\nFirst Occurrance : "+firstoccurance(a, 4, 0));

        System.out.print("\nLast Occurrance : "+lastoccurrance(a, 4, 0));
    }
}
