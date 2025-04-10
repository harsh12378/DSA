class Sorting {

//bubble sort

    static void Bubblesort(int[] arr) {
        int start=0;
        int end=arr.length-1;
        for (int j = 0; j <end ; j++) {
            for (int i = 0; i < end;i++) {
                if(arr[i]>arr[i+1]) swap(arr,i,i+1);
                else i++;

            }
        }

        System.out.println("sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print( arr[i]+" ");
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

//cyclic sort

    static void Cyclicsort(int[] arr)
    {

        int i=0;
        while(i< arr.length){
            int correctidx=arr[i]-1;
            if (arr[i]!=arr[correctidx]) {
                swap(arr,i,correctidx);
            }
            else i++;
        }


        System.out.println("sorted arrray= " +Arrays.toString(arr));
    }

//selection sort

        static void selectionsort(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                int min=minimumidx(arr,i);
                for (int j=i; j < arr.length; j++) {
                    swap(arr,min,j);
                }
            }

            System.out.println(Arrays.toString(arr));
        }


        static int minimumidx(int[] arr, int start){
            int min=start;
            while(start< arr.length){
                if(arr[start]<arr[min]){
                    min=start;
                }
                else start++;
            }
            //System.out.println(min);
            return min;
        }

        //insertionsort

    static void insertionsort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
        System.out.println(" sorted array= " + Arrays.toString(arr));
    }


}

