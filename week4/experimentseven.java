package Week4;

public class experimentseven {
    public static void main(String[] args) {
        
        char [] ch = {'0','1','0','1','1','1','0'};
        int n = ch.length -1;

        char[] ch2 = {'0','1','0','1','0','0','1','0','1'};
        int m =ch2.length -1;

        char[] ch3 = {'0','1','0','1','0','0','1','0','0','1','0','0'};
        int l =ch3.length -1;

        //Testing the variables below
        // System.out.println(n);
        // System.out.println(m);
        // System.out.println(l);
        // Working Properly

        Checkermethod(ch,ch2,ch3,n,m,l);
    }    

    public static void Checkermethod(char [] ch, char [] ch2,char [] ch3, int n, int m, int l) {

        if(ch[n] == '1' && ch[n-1] == '0' && ch[n-2] == '1') {
            System.out.println("String ch ends with 101");}
        else{
            System.out.println("String ch does not end with 101");}

        if(ch2[m] == '1' && ch2[m-1] == '0' && ch2[m-2] == '1') {
            System.out.println("String ch2 ends with 101");}
        else{
            System.out.println("String ch2 does not end with 101");} 
            
        if(ch3[l] == '1' && ch3[l-1] == '0' && ch3[l-2] == '1') {
            System.out.println("String ch3 ends with 101");}
        else{
            System.out.println("String ch3 does not end with 101");}    
    }    

}  