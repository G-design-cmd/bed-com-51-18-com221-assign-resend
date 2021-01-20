public abstract class Feed
{
    private double maize;
    private double soya;
    private double salt;
    private double gnuts;
    private java.util.Date date;
    protected Feed(){
        
    }
    protected Feed(double maize,double gnuts,double salt, double soya){
        
        this.maize=maize;
        this.soya=soya;
        this.salt=salt;
        this.gnuts=gnuts;
    }
    public void setMaize(double maize){
       this.maize=maize;
    }
    public double getMaize(){
        return maize;
    }
        public void setSoya(double soya){
        this.soya=soya;
    }
        public double getSoya(){
        return soya;
    }
    public java.util.Date getDate(){
        return date;
    }
     public void setGnuts(double gnuts){
       this.gnuts=gnuts;
    }
     public double getGnuts(){
        return gnuts;
    }
     public double getSalt(){
        return salt;
    }
    public void setSalt(double salt){
       this.salt=salt;
    }

    public abstract String doCalculations();
    
}
