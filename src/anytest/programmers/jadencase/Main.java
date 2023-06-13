package anytest.programmers.jadencase;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s){
        String[] strArr = s.split(" ");
        String answer = "";
        for(int i=0; i<strArr.length; i++){
            strArr[i] = strArr[i].toLowerCase();
            char ch = strArr[i].charAt(0);
            if(ch >= 'a' && ch <= 'z'){
                ch = (char)(ch + 'A' - 'a');
                strArr[i] = ch + strArr[i].substring(1, strArr[i].length());
            }
            answer += strArr[i] + " ";
        }
        answer.trim();
        return answer;
    }
}
