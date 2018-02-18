package week2.day2;

public class ArrayWrapper {

    static int size = 0;
    static int[] arr = new int[10];


    public void add(int num) {
        if(size >= arr.length) {
            copyArray();
        }
        arr[size++] = num;
    }

    private void copyArray() {
        int[] tmp = new int[arr.length * 2];
        System.arraycopy(arr, 0, tmp, 0, arr.length);
        arr = tmp;
    }
    public int[] sort(){

        for (int i = 1; i <arr.length; i++)
        {
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] >key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;}

    public int search(int value){
        int min = 0, max = arr.length - 1, mid = (arr.length - 1) / 2;
        while (min <= max) {
            if(arr[mid] == value) {
                return mid;
            } else if(arr[mid] > value) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            mid = (min + max) / 2;
        }
        return -1;
    }


    public int[] remove(int index) //Видаляє елемент з певної позиції але перед тим треба зробити Search щоб знайти index елементу
    {
        if (((index>0)||(index==0))&& (index<(arr.length-1))) {
            int[] copy = new int[arr.length-1];
            System.arraycopy(arr, 0, copy, 0, index);
            System.arraycopy(arr, index+1, copy, index, arr.length-index-1);
        }
        return arr;
    }

    public void removeValue(int value)
    {//перевірка чи існує такий  елемент чи ні
        if (value!=arr[search(value)]) {
            System.out.print("Value was deleted ");
        }
        else {
            System.out.print("Value was not deleted ");
        }
    }
    public int[] copy(){
        return arr.clone();
    }



    public String toSting(){

        return Arrays.toString(arr);
    }



    public int[] revers(){
        for(int i = 0; i < arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    public int max(){
        sort();
        return arr[arr.length-1];
    }


    public int min(){
        sort();
        return arr[0];
    }

}


