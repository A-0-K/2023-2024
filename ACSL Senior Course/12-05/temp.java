public class temp {
    public static void main(String[] args) {
        int x = 15;
        //int temp = 0;
        for (int i = 0; i  <3; i++){
            if (x >= 10){
                x=((x-2)%4)+2;
            }
            else if (x>6 && x <10){
                x = (x-1)%5+4;
            }
            else if (x<=6){
                x = x+5;
            }
            //System.out.println(i);  
            //System.out.println(x); 
        }
        //System.out.println(x);;
        System.out.println(4%4+2);
    }
}
