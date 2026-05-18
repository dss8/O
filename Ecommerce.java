import java.util.Scanner;
  
class Ecommerce {
               
    String productName;
    int quantity;
    double price;
    double total;
         
    Ecommerce(String name, int q, double p) {

        productName = name;
        quantity = q;
        price = p;
         
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product Name : ");
        String productName = sc.next();

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price : ");
        double price = sc.nextDouble(); 
            
        Ecommerce e1 = new Ecommerce(productName, quantity, price);
          
        e1.total = e1.quantity * e1.price;

        if (e1.total > 5000) {
              
            e1.total = e1.total - (e1.total * 0.10);   
        }

        System.out.println("====================================================================");
        System.out.println("                            INVOICE BILL                            "); 
        System.out.println("====================================================================");
              
        System.out.println("Product Name : " + e1.productName);
        System.out.println("Quantity : " + e1.quantity);
        System.out.println("Price : " + e1.price);
        System.out.println("Total Amount : " + e1.total);
             
        sc.close();

    }
         
}