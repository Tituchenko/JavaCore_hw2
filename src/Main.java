import java.sql.Array;
import java.util.Arrays;

/**
 * 1. Доделать сортировку подсчетом с урока (если нет, реализовать) классическим способом через промежуточный массив
 * (см. последние минут 10 семинара)
 *
 * 2. Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифрования и числовым ключом;
 *
 * 3. Написать метод, принимающий на вход массив чисел и параметр n. Метод должен осуществить циклический
 * (последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций;
 */


public class Main {
    public static void main(String[] args) {
        int[] a={1,5,1,3,4,-2,0,0,3,2};
        System.out.println("Изначальный массив:"+ Arrays.toString(a));
        System.out.println("Отсортированный массив:"+ Arrays.toString(sortCount((a))));
        System.out.println("*".repeat(100));

        String s="Съеш еще этих французких булок";
        System.out.println("Исходная фраза:"+s);
        String codeS=cezarCode(s,true,3);
        System.out.println("Зашифрованная фраза:"+codeS);
        System.out.println("Расшифрованная фраза:"+ cezarCode(codeS,false,3));
        System.out.println("*".repeat(100));

        int[] b={1,2,3,4,5};
        System.out.println("Изначальный массив:"+ Arrays.toString(b));
        System.out.println("Сдвинутый массив:"+ Arrays.toString(moveArray(b,2)));
    }

    public static int[] sortCount(int[] arr){
        if (arr.length==0) {
            return null;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        int[] tempArr= new int[max-min+1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[arr[i]-min]++;
        }
        int[] result=new int[arr.length];
        int curI=0;
        for (int i = 0; i <= max-min; i++) {
            for (int j = 0; j < tempArr[i]; j++) {
                result[curI++]=i+min;
            }
        }
        return result;

    }

    public static String cezarCode (String s,Boolean encode,int key){
        String result="";
        int z=1;
        if (!encode){
            z=-1;
        }
        for (int i = 0; i < s.length(); i++) {
            result+=(char)((int)s.charAt(i)+z*key);
        }
        return result;

    }

    public static int[] moveArray(int[] arr,int n){
        int[] result=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[(i+n)%arr.length]=arr[i];
        }
        return result;
    }
}