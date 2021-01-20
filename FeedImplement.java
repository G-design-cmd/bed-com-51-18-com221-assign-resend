public class FeedImplement extends Feed{
    private double soya;
    private double salt;
    private double gnuts;
    private double maize;

    FeedImplement(){

    }
    FeedImplement(double maize,double gnuts,double salt, double soya){
    }
    
    public void setSoyaRatio(double soya){
    this.soya=soya;
    }
    public void setMaizeRatio(double maize){
    this.maize=maize;
    }
        public void setSaltRatio(double salt){
    this.salt=salt;
    }
        public void setGnutRatio(double gnuts){
    this.gnuts=gnuts;
    }

public double getMaizeRatio(){
    double ratio1=(6.0/10)*maize;
    return ratio1;
}  
public double getSoyaRatio(){
    double ratio2=(2.0/10)*soya;
    return ratio2;
}  
public double getGnutRatio(){
   double ratio3=(1.5/10)*gnuts;
    return ratio3;
} 

public double getSaltRatio(){
     double ratio4=(0.5/10)*salt;
    return ratio4;
}  
@Override
public String doCalculations(){
    double total=(getGnutRatio()+getMaizeRatio()+getSaltRatio()+getSoyaRatio());
    return"You will use Kilograms (KG)"+"\n"+
    " Maize       : "+getMaizeRatio()+"\n"+
    " Soya        : "+getSoyaRatio()+"\n"+
    " Groundnuts  : "+getGnutRatio()+"\n"+
    " Salt        : "+getSaltRatio()+"\n"+

" You will make "+total+" kgs of feeds";
}
}