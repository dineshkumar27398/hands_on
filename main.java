import java.util.Scanner;

abstract class Card{
    protected String holderName, cardNumber, expiryDate;
    Card(String holderName, String cardNumber, String expiryDate){
        this.holderName=holderName;
        this.cardNumber=cardNumber;
        this.expiryDate=expiryDate;
    }    
}
class MembershipCard extends Card{
    private int rating;
    MembershipCard(String holderName, String cardNumber, String expiryDate, int rating){
        super(holderName, cardNumber, expiryDate);
        this.rating=rating;
    }
    void display(){
        System.out.println(holderName+"'s Membership Card Details:");
        System.out.println("Card Number "+cardNumber); 
        System.out.println("Rating "+rating);
    }
}
class PaybackCard extends Card{
    private int pointsEarned;
    private double totalAmount;
    PaybackCard(String holderName, String cardNumber, String expiryDate, int pointsEarned, double totalAmount){
        super(holderName, cardNumber, expiryDate);
        this.pointsEarned=pointsEarned;
        this.totalAmount=totalAmount;
    }
    void display(){
        System.out.println(holderName+"'s Membership Card Details:");
        System.out.println("Card Number "+cardNumber); 
        System.out.println("Points Earned "+pointsEarned);
        System.out.println("Total Amount "+totalAmount);
    }
}
class main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String cardDetailsFull;
        int choice, rating, pointsEarned;
        double totalAmount;
        System.out.println("Select card");
        System.out.println("1. Payback Card ");
        System.out.println("2. Membership Card");
        choice=scanner.nextInt();
        System.out.println("Enter the Card Details:");
        cardDetailsFull=scanner.next();
        String cardDetails[]=cardDetailsFull.split("\\|",3);
        //System.out.println(cardDetails[1]);
        switch(choice){
            case 1: 
                    System.out.println("Enter points in card");
                    pointsEarned=scanner.nextInt();
                    System.out.println("Enter Amount");
                    totalAmount=scanner.nextDouble();
                    PaybackCard objPaybackCard= new PaybackCard(cardDetails[0], cardDetails[1], cardDetails[2], pointsEarned, totalAmount);
                    objPaybackCard.display();
                    break;
            case 2:
                    System.out.println("Enter rating in card"); 
                    rating=scanner.nextInt();
                    MembershipCard objMembershipCard=new MembershipCard(cardDetails[0], cardDetails[1], cardDetails[2], rating);
                    objMembershipCard.display();
                    break;
            default: System.out.println("Invalid option!");            
        }
    }
}