// Main.java

import java.util.*; 
import java.util.stream.*; 

class Main
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Expenses> expenses = new ArrayList<>();
        List<String> expenseTypes = Arrays.asList("food","rent","shopping","groceries","electricity");
        expenseTypes.forEach(type -> {
             System.out.println("Enter expense for "+type);
            expenses.add(new Expenses(type, Double.parseDouble(sc.nextLine())));
        });
       System.out.println("Enter salary");
       Double salary = sc.nextDouble();
       Double totalExpenses = expenses.stream().reduce(0.0, (subTotal, expense) -> subTotal + expense.getCost(), Double::sum);
       if(totalExpenses>salary) { System.out.println("Expenses exceeds Salary"); }
       else { System.out.println("Savings amount will be Rs."+(salary-totalExpenses)); }
       sc.close();
    }
}


// Expenses.java

class Expenses{
    private String expenseType;
    private Double cost;
    
    Expenses(){}
    Expenses(String expenseType, Double cost){
        this.expenseType = expenseType;
        this.cost = cost;
    }
    String getExpenseType(){ return this.expenseType; }
    Double getCost(){ return this.cost; }
    void setExpenseType(String expenseType) { this.expenseType = expenseType ;}
    void setCost(Double cost) { this.cost = cost; }
}
