public class Hamm3{
        public static void main(String[] args){
        int[] inp = {1,1,0,0,0,0,1,1,1,0,0,1};
        int[] msg = {2,9,9,1,9,1,0,0,9,0,0,1,1,1,0,0,9,1};
        String Parsch = "ODD";
        int msglength = msg.length;
        int s3 = 0;
        int h3 = 0;
        for(int i = 3; i < msglength; i += 8){
            s3 = s3 + msg[i];
            if(i + 1 < msglength)
             s3 = s3 + msg[i + 1];
             if(i + 2 < msglength)
             s3 = s3 + msg[i + 2];
             if(i + 3 < msglength)
             s3 = s3 + msg[i + 3];

        }
        if(Parsch.equals("ODD")){
            int r = s3 % 2;
            if(r != 0){
                h3 = 0;
            }else {
                h3 = 1;
            }
        }
        System.out.println(msglength);
        System.out.println(s3);
        System.out.println(h3);
    }
}