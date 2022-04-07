// Main.java

import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);
        Department dep = new Department();
        System.out.println("Enter the name of the staff:");
        dep.staff.setStaffName(sc.nextLine());
        System.out.println("Enter the staff designation:");
        dep.staff.setDesignation(sc.nextLine());
        System.out.println("Enter the department name:");
        dep.setDepartmentName(sc.nextLine());
        dep.displayStaff();
        sc.close();
	}
}


// Department.java

    public class Department {
        private String departmentName;
        Staff staff = new Staff();
    	
        void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }
        
        String getDepartmentName() {
            return this.departmentName;
        }
        
        public void displayStaff() {
            System.out.println(staff.getStaffName()+" is working in the "+this.departmentName+" department as "+staff.getDesignation());
        }
    }


// Staff.java

public class Staff {
	private String staffName,designation;
    
    void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    void setDesignation(String designation) {
        this.designation = designation;
    }
    
    String getStaffName() {
        return this.staffName;
    }
    
    String getDesignation() {
        return this.designation;
    }
    
}
