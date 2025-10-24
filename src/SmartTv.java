import java.util.Scanner;

public class SmartTv implements Device{
    Scanner sc = new Scanner(System.in);
    @Override
    public void turnOn(){
        System.out.println("TV turn on");
    }
    public void turnOff(){
        System.out.println("TV turn off");
    }
    public void set(int x){
        System.out.println("Choose chanel");
        x=sc.nextInt();
        if(x==1){
            System.out.println("News chanel");
        }
        else if(x==2){
            System.out.println("Sports chanel");
        }
    }
    public void ecoMode(){
        System.out.println("Eco mode");
    }

}