import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N]; //배열 생성

        for(int i=0;i<N;i++)
        {
            arr[i]= sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>(); //스택 생성

        int count = 1; //stack에 숫자 추가


        List<String> list = new ArrayList<>(); //+,- 담을 리스트
        int check = 1;

        for(int k=0;k<N;k++)
        {
            if(count <=arr[k])
            {
                while(count<=arr[k])
                {
                    stack.add(count);
                    count ++;
                    list.add("+");
                }

                stack.pop();
                list.add("-");
            }
            else //count > arr[k] 이 경우에 처음 pop 한 값이 나중에 pop 한 값보다 크면 수열을 만들 수 없다.
            {
                int i = stack.pop();


                if(i>arr[k])
                {
                    System.out.println("NO");
                    check = 0;
                    break;
                }
                else {
                    list.add("-");
                }
            }


        }

        if(check == 1)
        {
            for(String v: list)
            {
                System.out.println(v);
            }
        }

    }
}
