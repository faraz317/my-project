public class Hamm2{
    public static void main(String[] args){
        int[] inp = {1,1,0,0,0,0,1,1,1,0,0,1};
        int[] msg = {2,9,9,1,9,1,0,0,9,0,0,1,1,1,0,0,9,1};
        String Parsch = "ODD";
        int msglength = msg.length;
        int s2 = 0;
        int h2 = 0;
        for(int i = 2; i < msglength; i += 4){
            s2 = s2 + msg[i];
            if(i + 1 < msglength){
                s2 = s2 + msg[i + 1];
            }
        }
        if(Parsch.equals("ODD")){
            int r = s2 % 2;
            if(r != 0){
                h2 = 0;
            }else {
                h2 = 1;
            }
        }
        System.out.println(msglength);
        System.out.println(s2);
        System.out.println(h2);
    }
}