1. 두개의 배열을 합치는 방법을 two pointers 로 진행하기 
'''
```
class Main {
public ArrayList<Integer> solution(int n m int m, int [] a. int [] b) {
ArrayList<Integer> answer = new ArrayList<>();
int p1 = 0 , p2 = 0 ;
while(p1 < n && p2 < m) {
if(a[p1]<b[p2]) answer.add(a[p1++]);
else answer.add(b[p2++]);
}
while(p1 < n) answer.add(a[p1++]);
while(p2 < m) answer.add(b[p2++]);

return answer;
}
public static void main(String[] args) {
Main T = new Main();
Scanner kb = new Scanner(System.in);
int n = kb.nextInt();
int[] a = new int[n];
for(int i = 0 ; i < n ; i++ )  {
a[i] = kb.nextInt();
}
int m = kb.nextInt();
int[] b = new int[m];
for(int i = 0 ; i < m ; i++) {
b[i] = kb.nextInt();
}
for(int x : T.solution(n,m,a,b)) System.out.print(x+" ");
}
}
``` 
'''

매출 배열 중 연속된 n일 매출을 구하는 문제를 sliding window 로 해결하기 

tip : window의 크기를 계속해서 구하는 것이 아닌 변하는 값만 반영하기( 처음 값을 빼고 들어온 값을 더한다) sum + arr[i] - arr[i--k]

'''
```
class Main {
public ArrayList<Integer> solution(int n, int k, int [] arr) {
int answer, sum = 0;
for(int i = 0 ; i < ; i++) sum += arr[i];
answer = sum;
for(int i = k ; i < n ;i++) {
sum += (arr[i] - arr[i-k]);
answer = Math.max(answer,sum);
}
return answer;
}

}
​```
'''