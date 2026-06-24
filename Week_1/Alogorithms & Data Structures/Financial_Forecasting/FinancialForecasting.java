public class FinancialForecasting {

    public static double calculateFutureRevenue(double currentRevenue, double growthRate, int years) {
        if(years<=0) {
            return currentRevenue;
        }
        return calculateFutureRevenue(currentRevenue,growthRate, years-1)*(1+growthRate);
    }
    public static void main(String[]args){
        double currentRevenue=100000;
        double growthRate=0.20;//Growth rate of 20%
        int years=5;
        double futureRevenue=calculateFutureRevenue(currentRevenue,growthRate,years);
        System.out.println("Future Revenue after "+years+" years: "+futureRevenue);
    }
}
