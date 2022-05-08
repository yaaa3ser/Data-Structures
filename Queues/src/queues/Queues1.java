package queues;
public class Queues1 {
    private double lamda;
    private double mu;
    private int time;
    private boolean validLamda = false;
    private boolean validMu = false;
   
    public Queues1(double lamda , double mu , int time){
        this.lamda = lamda;
        this.mu = mu;
        this.time = time;
    }
    public int numOfCustomersInTime_t(double lamda , double mu , int time){
        int numOfCustomersInTime_t ;
        numOfCustomersInTime_t = (int)(time/(1/lamda)) - (int)((time-(1/lamda))/(1/mu));
        return numOfCustomersInTime_t;
    }
    
}
