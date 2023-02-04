import entities.Sale;
import services.CommissionCalculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> suportedRegions = new ArrayList<String>() {{
        add("NORTH");
        add("SOUTH");
        add("EAST");
        add("WEST");
    }
    };

    static String regionsStr = String.join(" | ", suportedRegions);

    public static void main(String[] args) {

        System.out.println("Calculate your comission!");

        CommissionCalculator calculator = new CommissionCalculator();
        String exitCommand = "";
        Scanner scanner = new Scanner(System.in);

        while (exitCommand != "X") {
            try{
                System.out.println("Enter the SALES_AMOUNT: ");
                double salesAmount = scanner.nextDouble();

                System.out.println("Enter the sales REGION:" + regionsStr);
                String region = scanner.next().toUpperCase();

                if(!suportedRegions.contains(region)){
                    System.out.println("Please select one of the supported regions:" + regionsStr);
                    scanner.nextLine();
                    continue;
                }

                System.out.println("Is it a PRIME Customer? Y or N");

                String prime = scanner.next().toUpperCase();

                boolean isPrime = false;
                if(!prime.equals("Y") && !prime.equals("N")){
                    System.out.println("Please select Y or N for prime customer.");
                    scanner.nextLine();
                    continue;
                }else{
                    if(prime.equals("Y"))
                        isPrime = true;
                }

                Sale sale = new Sale(salesAmount, region, isPrime);

                calculator.calculate(sale);

                System.out.println("SALES_AMOUNT: $" + salesAmount);
                System.out.println("PRIME_DISCOUNT: " + sale.getDiscountPercentage()*100 + "%");
                System.out.println("TOTAL_SALE_AMOUNT: $" + sale.getAmount());
                System.out.println("REGION:" + region);
                System.out.println("COMMISSION_RATE: " + sale.getCommissionPercentage()*100 + "%");
                System.out.println("TOTAL_COMMISSION: $" + sale.getCommission());

                System.out.println("Press X to exit or C to continue:");
                exitCommand = scanner.next().toUpperCase();

            } catch(ArithmeticException exception){
                System.out.println(exception.getMessage());
                scanner.nextLine();
            }
            catch(InputMismatchException exception){
                System.out.println("Please input a number!");
                scanner.nextLine();
            }
        }
    }
}