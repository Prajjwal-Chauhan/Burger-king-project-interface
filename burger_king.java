import java.util.*;

public class burger_king {

    ArrayList<String> S = new ArrayList<>();
    Scanner choice = new Scanner(System.in);

    void order(burger_king obj, int sum) {
        System.out.println(" ");
        System.out.println("* MAIN MENU *");
        System.out.println("1) 1 Veg Burger + 1 coke : 100 Rs");
        System.out.println("2) 1 Veg Burger + fries + coke : 150 Rs");
        System.out.println("3) 1 Veg Burger : 30 Rs");

        System.out.print("Choose your combo : ");
        int option = choice.nextInt();
        if (option > 3) {
            System.out.println("* Not in the MENU *");
            obj.order(obj, sum);
        } else {
            System.out.print("How much you wanna order : ");
            int quantity = choice.nextInt();
            System.out.println(" ");
            switch (option) {
                case 1:
                    System.out.printf("You Ordered %d Veg Burgers with 1 coke each%n", quantity);
                    System.out.println(" ");
                    obj.S.add("1 Veg Burger + 1 coke : " + quantity + " : 100 Rs");
                    obj.bill(quantity * 100, obj, sum);
                    break;

                case 2:
                    System.out.printf("You Ordered %d Veg burgers with fries and a coke each%n", quantity);
                    System.out.println(" ");
                    obj.S.add("1 Veg Burger + fries + coke : " + quantity + " : 150 Rs");
                    obj.bill(quantity * 150, obj, sum);
                    break;

                case 3:
                    System.out.printf("You Ordered %d Veg Burgers%n", quantity);
                    System.out.println(" ");
                    obj.S.add("1 Veg Burger : " + quantity + " : 30 Rs");
                    obj.bill(quantity * 30, obj, sum);
                    break;

                default:
                    System.out.println("* *");

                    break;
            }
        }
    }

    void bill(int a, burger_king obj, int sum) {
        choice.nextLine();
        System.out.println("Do you want to confirm your order ?");
        System.out.print("Please enter YES for confirm NO for no : ");
        String s12 = choice.nextLine();

        if (s12.equals("yes") || s12.equals("Yes") || s12.equals("YES")) {
            System.out.println(" ");
            System.out.println("Order placed, here is your total bill : " + (sum + a));
            System.out.println(" ");
            sum = sum + a;
            System.out.println("Would you like to order another item ?");
            String abc = choice.nextLine();
            if (abc.equals("yes") || abc.equals("Yes") || abc.equals("YES")) {
                obj.order(obj, sum);
            } else {
                obj.S.add(" ");
                obj.S.add("Grand Total :: " + sum + " Rs");
                System.out.println("");
            }
        } else {
            obj.S.remove(obj.S.size() - 1);
            System.out.println("Order cancelled, Would you like to order another item ?");
            String abc = choice.nextLine();
            if (abc.equals("yes")) {
                obj.order(obj, sum);
            } else {
                obj.S.add(" ");
                obj.S.add("Grand Total :: " + sum + " Rs");
                System.out.println(" ");
            }
        }

    }

    public static void main(String[] args) {
        int sum = 0;
        burger_king obj = new burger_king();
        System.out.println("");
        System.out.println("////* Welcome to Burger King *////");
        obj.order(obj, sum);

        System.out.println(" Combo : Quantity : Prize");
        System.out.println(" ");
        for (int i = 0; i < obj.S.size(); i++) {
            System.out.println(obj.S.get(i) + " ");
        }
        System.out.println(" ");
        System.out.println("Thanks for coming");

    }
}
