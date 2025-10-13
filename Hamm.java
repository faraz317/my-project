public class Hamm{
    public static void main(String[] args){
        int[] inp = {1,1,0,0,0,0,1,1,1,0,0,1};
        int[] msg = {2,9,9,1,9,1,0,0,9,0,0,1,1,1,0,0,9,1};
        String Parsch = "ODD";
        int msglength = msg.length;
        int s1 = 0;
        int h1 = 0;
        for(int i = 3; i < msglength; i += 2){
            s1 = s1 + msg[i];
        }
        if(Parsch.equals("ODD")){
            int r = s1 % 2;
            if(r != 0){
                h1 = 0;
            }else {
                h1 = 1;
            }
        }
        System.out.println(msglength);
        System.out.println(s1);
        System.out.println(h1);
    }
}