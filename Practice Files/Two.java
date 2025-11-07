public class Two{
    public static void main(String[] args) {
        int i=1,j=0;
        int n=0;
        while(i<=9){
            while(j<=9)
            n=i*1000+i*100+j*10+j;
            if (n==(Math.pow((int)Math.sqrt(n),2))){
                System.out.println(n);
            }
            i++;
            j++;
        }
     }
}