import java.util.Scanner;

/////////// clear consolar///////////////

class ClearConsole {

    public final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Linux")) {
                System.out.print("\033\143");
            } else if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

public class Demo {

    private static String userName = "lakmal";
    private static String passWord = "1234";
    private static String[][] supplies = new String[0][2]; 
    private static int index = 0;
    static String[] Categories = new String[1];
    static String[][] Item = new String[1][6];
    
    //// login page//////////////

   
    public static void loginPage() {
        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|                LOGIN PAGE                                   |");
        System.out.println("+-------------------------------------------------------------+\n\n");

        do {
            System.out.print("User Name: ");
            String username = new Scanner(System.in).next();

            if (userName.equals(username)) {
                break;
            } else {
                System.out.println("User name is invalid. Please try again!\n");
            }
        } while (true);

        do {
            System.out.print("\nPassword: ");
            String password = new Scanner(System.in).next();

            if (passWord.equals(password)) {
                homePage();
                return;
            } else {
                System.out.println("Password is incorrect. Please try again!\n");
            }
        } while (true);
    }
   /////////home page/////////////  //ok//

    public static void homePage() {
       ClearConsole.clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                     WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                                                                      |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Change Credentials                          [2] Supplier Manage");
        System.out.println("[3] Stock Manage                                [4] Log out");
        System.out.println("[5] Exit the System");
        System.out.println();

  
        boolean valid;
        do {
            System.out.print("Enter an option to continue > ");
           int num = new Scanner(System.in).nextInt();
            valid = checkNumValid(num);

            switch (num) {
                case 1:
                   ClearConsole.clearConsole();
                    changeCredentials();
                    break;
                case 2:
                  ClearConsole.clearConsole();
                    supplierManagement();
                    break;
                 case 3:
                     ClearConsole.clearConsole();
                     stockManagement();
                      break;
                      
                case 4:
                    ClearConsole.clearConsole();
                    loginPage();
                    return;
                case 5:
                   ClearConsole.clearConsole();
                    System.out.print("** Goodbye **");
       
                    break;
            }
        } while (!valid);
    }
     public static boolean checkNumValid(int num) {
        return num >= 1 && num <= 5;
    }
    
/////   01)   changeCredentials//////////  // ok //
    public static void changeCredentials() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                 CREDENTIAL MANAGE                              |");
        System.out.println("+----------------------------------------------------------------+\n\n");

        char yesOrNo = '0';
        verifyUsername();
        System.out.println("Hey " + userName);
        verifyPassword();
        passwordChanger();
        yesOrNo = goBackToHomeOrNot();

        if (yesOrNo == 'Y' || yesOrNo == 'y') {
           ClearConsole.clearConsole();
            homePage();
        } else if (yesOrNo == 'N' || yesOrNo == 'n') {
            while (yesOrNo == 'N' || yesOrNo == 'n') {
                System.out.println("\nYou can change your Password again now!\n\n");
                passwordChanger();
                yesOrNo = goBackToHomeOrNot();
                if (yesOrNo == 'Y' || yesOrNo == 'y') {
                   ClearConsole.clearConsole();
                    homePage();
                    return;
                }
            }
        }
    }
 public static char goBackToHomeOrNot() {
        System.out.print("\n\nPassword Changed Successfully! Do you want to Go to home Page (Y/N) : ");
        return new Scanner(System.in).next().charAt(0);
    }
    public static void verifyUsername() {
        String tempUserName = "";
        while (!tempUserName.equals(userName)) {
            System.out.print("Please Enter the User Name to verify it's you : ");
            tempUserName = new Scanner(System.in).next();
            if (!tempUserName.equals(userName)) {
                System.out.println("invalid user name. try Again !\n");
            }
        }
    }

    public static void verifyPassword() {
        String tempPassword = "";

        while (!(passWord).equals(tempPassword)) {
            System.out.print("Enter your current password : ");
            tempPassword = new Scanner(System.in).next();
            if (!(passWord).equals(tempPassword)) {
                System.out.println("incorrect Password. Try again!\n");
            }
        }
    }

    public static void passwordChanger() {
        System.out.print("Enter your new password : ");
        String newPassword = new Scanner(System.in).next();
        passWord = newPassword;
    }

   
///////////////////////   02) supplierManagement      /////////////////////////////////////
    

    public static void supplierManagement() {
      ClearConsole.clearConsole();

        System.out.println("+---------------------------------------------------------------------+");
        System.out.println("|                  SUPPLIER MANAGE                                    |");
        System.out.println("+---------------------------------------------------------------------+\n\n");

        System.out.println("[1] Add Supplier                         [2] Update Supplier");
        System.out.println("[3] Delete Supplier                      [4] View Suppliers");
        System.out.println("[5] Search Supplier                      [6] Home Page");
        System.out.println();

       
        boolean valid;
        do {
            System.out.print("Enter an Option to Continue > ");
           int option = new Scanner(System.in).nextInt();
            valid = checkOptionNumber6(option);

            switch (option) {
                case 1:
                    ClearConsole.clearConsole();
                    addSupplier();
                    break;
                    case 2:
                       ClearConsole.clearConsole();
                       updateSupplier();
                       return;
                       case 3: 
                          ClearConsole.clearConsole();
                          supplierDelete();
                          return;
                          case 4:
                           ClearConsole.clearConsole();
                           viewSupplier();
                           return;
                             case 5:
				 ClearConsole.clearConsole();
					searchSupplier();
                    return;
                    case 6:
                     ClearConsole.clearConsole();
                     homePage();
                     return;
                      default:
                    System.out.println("Invalid option! Please try again.\n");
                    valid = false;
                    continue;
            }
        } while (!valid);
    }
     public static boolean checkOptionNumber6(int optionNumber) {
        return optionNumber >= 1 && optionNumber <= 6;
    }
    
    
    /////////////////           01)1  addSupplier         ////////////////////////////////////
      public static void addSupplier() {
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                     ADD SUPPLIER                                        |");
        System.out.println("+-------------------------------------------------------------------------+\n\n");

        while (true) {
            supplies = growArray();
            boolean correct = false;
            char ask;
            do {
                System.out.print("\n\nSupplier ID  : ");
                String id = new Scanner(System.in).next();
                correct = checkId(supplies, id);

                if (correct) {
                    supplies[index][0] = id;

                    System.out.print("Supplier Name: ");
                    supplies[index][1] = new Scanner(System.in).next();
                    break;
                } else {
                    System.out.println("already exists. Try another supplier id!");
                }

            } while (true);
            index++;
            System.out.print("added successfully! Do you want to add another supplier (Y/N) ? ");
            ask = new Scanner(System.in).next().charAt(0);
                       if (ask == 'Y' || ask == 'y') {
						    ClearConsole.clearConsole();
						    addSupplier();
						    
						   
                continue;
               
            } else if (ask == 'N' || ask == 'n') {
              ClearConsole.clearConsole();
                break;
            }
        }
        supplierManagement();  
    }
 public static String[][] growArray() {
        String[][] newSupplies = new String[supplies.length + 1][2];

        for (int i = 0; i < supplies.length; i++) {
            newSupplies[i][0] = supplies[i][0];
            newSupplies[i][1] = supplies[i][1];
        }

        return newSupplies;
    }
 /*   public static boolean checkId(String id){
		boolean checked=true;
		for (int i = 0; i < (supplies).length; i++){
			if(id.equals(supplies[i][0]))
				checked=false;
		}
		return checked;
	}*/
	
    
   ///////////     01) 2    updateSupplier           ////////////////////////
   	
public static void  updateSupplier(){

		System.out.println("+---------------------------------------------------------------------------+");
		System.out.println("|                            UPDATE SUPPLIER                                |");
		System.out.println("+---------------------------------------------------------------------------+");
		
int nameIndex = 0;
do{
System.out.print("\n\nSupplier id  : ");
String id=new Scanner(System.in).next();
	boolean correct = checkId(id);
	if(correct) {
					System.out.println("Can't find supplier id. Please try again!");
				} 
				else{
					while(true) {
					 nameIndex=findNames(id);
				System.out.println("Supplier name : " + supplies[nameIndex][1]);
				System.out.print("\nEnter the new supplier name: ");
						String newName = new Scanner(System.in).next();
							supplies[nameIndex][1] = newName;
						
System.out.print("\nUpdated succesfully! Do you want to update another supplier (Y/N) : ");
						char y = new Scanner(System.in).next().charAt(0);
						
							
						if( y =='y' | y == 'Y' ) {
							  ClearConsole.clearConsole();
							  updateSupplier();
							  
							break;
						}
						else if( y == 'n' | y == 'N' ) {
						
							supplierManagement();
						}
					}
				}
			} while(true);
	}



	public static int findNames(String id){
		int nameIndex = 0;
		for (int i = 0; i < (supplies).length; i++){
			if(id.equals(supplies[i][0])) {
				nameIndex = i;
				break;
			}			
		}
		return nameIndex;
	}

    public static boolean checkId(String[][] array, String id) {
		 boolean checked = true;
        for (int i = 0; i < array.length; i++) {
            if (id.equals(array[i][0])) {
				   checked = false;
                break; 
            }
        }
        return checked; 
        
    }

   
  /////////      01) 3    supplierDelete        //////////////////////////////////////////////////// 
  
	public static void supplierDelete() {
		
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                                                                   Delete Supplier                                                                                               |");
		System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		
do{
			System.out.print("\n\nSupplier id  : ");
			String id = new Scanner (System.in).next();
			boolean correct = checkId(id);
	if(correct){
					System.out.println("Can't find supplier id. try again!");
				} else {
					while(true) {

			supplies=	removeId(id);
				
					System.out.print("deleted succesfully! Do you want to delete another ? (Y/N) : ");
					char y = new Scanner(System.in).next().charAt(0);
						if( y == 'Y' | y == 'y' ) {
							
								     ClearConsole.clearConsole();
							//	System.out.println("No more supplier IDs to delete.");
							supplierDelete();
						} else if( y == 'N' | y == 'n' ) {
							supplierManagement();
						}
					}	
				}
			}while(true);
		
	}
							
	
	public static String[][] removeId(String id) {
    if (supplies.length == 0) {
        System.out.println("Suppliers array is empty. Cannot remove element.");
        return supplies;
    }

    int tempId = showIds(id);
    if (tempId == -1) {
        System.out.println("Supplier ID not found. Cannot remove element.");
        return supplies;
    }

    String[][] temp = new String[supplies.length - 1][2];
    int index1 = 0;

    for (int i = 0; i < supplies.length; i++) {
        if (i != tempId) {
            for (int j = 0; j < supplies[i].length; j++) {
                temp[index1][j] = supplies[i][j];
            }
            index1++;
        }
    }

    return temp;
}
	

	public static int showIds(String id) {
		int tempId = -1;
		for (int i = 0; i < (supplies).length; i++) {
			if (id.equals(supplies[i][0])) {
				tempId = i;
				break;
			}
		}
		return tempId;
	}
	public static boolean checkId(String id){
		boolean checked=true;
		for (int i = 0; i < (supplies).length; i++){
			if(id.equals(supplies[i][0]))
				checked=false;
		}
		return checked;
	}
	
 
  /////////        01) 4  viewSupplier   //////////////////////
  
public static void viewSupplier() {
		System.out.printf("+------------------------------------------------------------------------------+\n");
		System.out.printf("|                     	     VIEW SUPPLIER                                    |\n");
		System.out.printf("+------------------------------------------------------------------------------+\n\n");

		System.out.println("+--------------------+--------------------+");
		System.out.printf("| %-18s | %-18s |\n", "SUPPLIER ID", "SUPPLIER NAME");
		System.out.println("+--------------------+--------------------+");

		for (int i = 0; i < (supplies).length; i++) {
			System.out.printf("| %-18s | %-18s |\n", supplies[i][0], supplies[i][1]);
		}
	System.out.println("+--------------------+--------------------+");

		System.out.print("\nDo you want to go to the Supplier Management page (Y): ");
		char y = new Scanner(System.in).next().charAt(0);
		if (y == 'Y' || y == 'y') {
			supplierManagement();
			return;
		} else if (y == 'N' || y == 'n') {
			System.out.print("Press (Y) anytime to go back to the Supplier Management Page: ");
			y = new Scanner(System.in).next().charAt(0);

			if (y == 'Y' || y == 'y') {
				      ClearConsole.clearConsole();
				supplierManagement();
			}
		}
	}
    ///////////////01) 5 searchSupplier ////////////////////////////////////
	
	 
    public static void searchSupplier() {
		
		
		System.out.println("+--------------------------------------------------------------------------------+");
		System.out.println("|                      SEARCH SUPPLIER                                           |");
		System.out.println("+--------------------------------------------------------------------------------+");
		
		do {
			
			System.out.print("\n\nSupplier iD : ");
			String id =new Scanner(System.in).next();
			boolean correct = checkIds(id);
			if(correct) {
					System.out.println("Can't find supplier id. try again!");
				} 
				else {
					
					while(true) {
			int name = findName(id);
						System.out.println("Supplier name : " +supplies[name][1]);
						
						System.out.print("added succesfully! Do you want to add another find (Y/N) ? : ");
						char y = new Scanner(System.in).next().charAt(0);
						
						if( y =='y' | y == 'Y' ) {
							 ClearConsole.clearConsole();
							 searchSupplier();
							break;
						}
						else if( y == 'n' | y == 'N' ) {
							supplierManagement();
						}
					}
				}
			} while(true);
	}
    
    public static int findName(String id){
		int nameIndex = 0;
		for (int i = 0; i < (supplies).length; i++){
			if(id.equals(supplies[i][0])) {
				nameIndex = i;
				break;
			}			
		}
		return nameIndex;
	}
      	
public static boolean checkIds(String id){
		boolean checked = true;
		for (int i = 0; i < (supplies).length; i++){
			if(id.equals(supplies[i][0]))
				checked=false;
		}
		return checked;
	}
    
     ////////////////////////////////////////////////////////////////////////////
     //// stockManagement();///////////////////
    /////////////////////////////////////////////////////////////////////////////
    
     public static void   stockManagement(){
		
        System.out.println("+------------------------------------------------------------------------------------+");
        System.out.println("|                       SUPPLIER MANAGE                                              |");
        System.out.println("+------------------------------------------------------------------------------------+\n\n");

        System.out.println("[1] Manage Item categories                        [2] Add Item");
        System.out.println("[3] Get Items Supplier Wise                       [4] View Items");
        System.out.println("[5] Rank Items Per Unit Price                     [6] Home Page");
        System.out.println();


    int optionNumber = 0;
		boolean valide;
    
    do {
            System.out.print("Enter an Option to Continue > ");
            optionNumber =new Scanner(System.in).nextInt();
   
              valide = checkOptionNumber6(optionNumber);

      switch (optionNumber) {
                case 1:
               	 ClearConsole.clearConsole();
					manageItemCategory();
                    return;
    default:
                    System.out.println("Invalid option! Please try again.\n");
                    valide = false;
                    continue;
                     case 2:
                 ClearConsole.clearConsole();
                    AddItem();
                    return;
                case 3:
				ClearConsole.clearConsole();
					displayItemsBySupplierWise();
                    return;
                case 4:
                   ClearConsole.clearConsole();
                   viewItemsByCategory();
                    return;
                case 5:
			ClearConsole.clearConsole();
				viewItemsByPriceAscending();
                    return;
                case 6:
				ClearConsole.clearConsole();
                    homePage();
                    return; 
            }
        } while (!valide);
		
	}
	
	//////////////         Sm 01  Manage Item categories //////////////////////
    public static void manageItemCategory() {
		
	   	 ClearConsole.clearConsole();
		
		System.out.println("+-----------------------------------------------------------------------------------+");
		System.out.println("|                   MANAGE ITEM CATEGORY                                            |");
		System.out.println("+-----------------------------------------------------------------------------------+\n\n");
	
		System.out.print  ("[1] Add new Item Category\t\t\t");
		System.out.println("[2] Delete Item Category");
		System.out.print  ("[3] Update Item Category\t\t\t");
		System.out.println("[4] Stock Management\n\n");
		int optionNumber = 0;
		boolean validity;
		
		do {
            System.out.print("Enter an Option to Continue > ");
            optionNumber =new Scanner(System.in).nextInt();
            validity = check4OptionValidity(optionNumber);

            switch (optionNumber) {
                case 1:
				 	 ClearConsole.clearConsole();
				addNewItemCategory();
				
                    return;
                      case 2:
                  	 ClearConsole.clearConsole();
                    deleteItemCategory();
                    return;
                case 3:
						 ClearConsole.clearConsole();
					updateItemCategory();
                    return;
                case 4:
                 	 ClearConsole.clearConsole();
                    stockManagement();
                    return;
                          
                default:
                    System.out.println("Invalid option! Please try again.\n");
                    validity = false;
                    continue;
            }
        } while (!validity);
        	
	}
	
                    
            public static boolean check4OptionValidity(int optionNumber) {
	
		boolean validity;
		if(optionNumber <= 4 && optionNumber > Long.MIN_VALUE ) {
			validity = true;	
		}
		else{
			validity = false;
		}
		return validity;
	}      
    
    //////////////////////////////////////////////
    
    
           /////////////////////////////////////////////////////////////////////
           ////////////  1... Add new Item Category ////////////////////
           
           
	public static void addNewItemCategory() {
		
		System.out.println("+-----------------------------------------------------------------------------------------+");
		System.out.println("|                     ADD NEW ITEM CATEGORY                                               |");
		System.out.println("+-----------------------------------------------------------------------------------------+\n\n");
		
		while (true) {
		System.out.print("\n\nEnter the new item category: ");
			String newCategory = new Scanner(System.in).next();

			boolean categoryAdded = false;
			for (int i = 0; i < Categories.length; i++) {
				if (Categories[i] == null) {
				Categories[i] = newCategory;
					categoryAdded = true;
					break;
				}
			}

			if (!categoryAdded) {
				growCategories();
			Categories[Categories.length - 1] = newCategory;
			}

			System.out.print("Added successfully! Do you want to add another category (Y/N): ");
			char yesOrNo =new Scanner(System.in).next().charAt(0);

			if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
				ClearConsole.clearConsole();
				addNewItemCategory();
				continue;
			}
			else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
			 	 ClearConsole.clearConsole();
			stockManagement();
				return;
			}	
			
		}
			
	}
	public static void growCategories() {
		String[] temp = new String[Categories.length + 1];

		for (int i = 0; i < Categories.length; i++) {
			temp[i] = Categories[i];
		}

		Categories = temp;
	}
    
    	
	
///////////////////////////////////////////////////////////////////////////////              
/////////////    [2] Delete Item Category          ///////////////////////////////
           
      	public static void deleteItemCategory() {
		System.out.println("+----------------------------------------------------------------------------------------------+");
		System.out.println("|                       DELETE ITEM CATEGORY                                                   |");
		System.out.println("+----------------------------------------------------------------------------------------------+\n\n");

		while (true) {
			System.out.print("\n\nEnter the category to delete: ");
			String categoryToDelete =new Scanner(System.in).next();

			boolean categoryFound = false;
			for (int i = 0; i < Categories.length; i++) {
				if (categoryToDelete.equals(Categories[i])) {
				Categories[i] = null;
					categoryFound = true;
					break;
				}
			}

			if (categoryFound) {
				System.out.println("Category deleted successfully!");
			} else {
				System.out.println("Category not found!");
			}

			Categories = removeNullCategories();

			System.out.print("Do you want to Delete Another category (Y) OR Go manage Item Category Page (N) ? (Y/N): ");
			char yesOrNo = new Scanner(System.in).next().charAt(0);

			if (yesOrNo == 'N' || yesOrNo == 'n') {
					 ClearConsole.clearConsole();
				manageItemCategory();
				return;
			}
		}
	}
	
	public static String[] removeNullCategories() {
		int nonNullCount = 0;

		for (String category : Categories) {
			if (category != null) {
				nonNullCount++;
			}
		}

		String[] nonNullCategories = new String[nonNullCount];
		int index = 0;

		for (String category : Categories) {
			if (category != null) {
				nonNullCategories[index] = category;
				index++;
			}
		}

		return nonNullCategories;
	}     
    
     //////////////////////////////////////////////////////////////////
         ////////////////////3] Update Item Category//////////////////////          
         ///////////////////////////////////////////////////////////////////
         
           	public static void updateItemCategory() {
		
		System.out.println("+-------------------------------------------------------------------------------------------------+");
		System.out.println("|                         UPDATING ITEM CATEGORY                                                  |");
		System.out.println("+-------------------------------------------------------------------------------------------------+\n\n");
		
		while(true) {
			System.out.print("\n\nEnter the category to update: ");
			String categoryToUpdate =new Scanner(System.in).next();

			boolean categoryFound = false;
			for (int i = 0; i < Categories.length; i++) {
				if (categoryToUpdate.equals(Categories[i])) {
					categoryFound = true;
					
					System.out.print("Enter the new category name: ");
					String newCategoryName =new Scanner(System.in).next();
				
					Categories[i] = newCategoryName;
					break;
				}
			}

			if (categoryFound) {
				
				System.out.println("Category updated successfully!");
				
			} 
			else {
				System.out.println("Category not found!");
			}
			
			System.out.print("Do you want to Update Another category(Y) OR  Go Supplier Manager Page(N)  ? (Y/N): ");
			char yesOrNo =new Scanner(System.in).next().charAt(0);

			if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
				updateItemCategory();
				 ClearConsole.clearConsole();
				 
				break;
			}
			else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
		 ClearConsole.clearConsole();
				manageItemCategory();
				return;
			}
		}
		
	}
         /////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///////////        [2] Add Item"     ////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    public static void AddItem() {
		
		System.out.println("+----------------------------------------------------------------------------------------------------+");
		System.out.println("|                          ADD ITEM                                                                  |");
		System.out.println("+----------------------------------------------------------------------------------------------------+\n\n");
		
		
		while (true) {
			if (!hasCategories()) {
				System.out.println("Oops! It seems like you don't have any item categories in the System.");
				System.out.print("Do you want to Add a new Item Category (Y/N): ");
				char yesOrNo =new  Scanner(System.in).next().charAt(0);

				if (yesOrNo == 'Y' || yesOrNo == 'y') {
				 ClearConsole.clearConsole();
					addNewItemCategory();
					return;
				} else if (yesOrNo == 'N' || yesOrNo == 'n') {
			 ClearConsole.clearConsole();
					stockManagement();
					return;
				}
			}

			if (!hasSuppliers()) {
				System.out.println("Oops! It seems like you don't have any Suppliers in the System.");
				System.out.print("Do you want to Add a new Supplier (Y/N): ");
				char yesOrNo = new Scanner(System.in).next().charAt(0);

				if (yesOrNo == 'Y' || yesOrNo == 'y') {
			 ClearConsole.clearConsole();
					addSupplier();
					return;
				} else if (yesOrNo == 'N' || yesOrNo == 'n') {
				 ClearConsole.clearConsole();
					stockManagement();
					return;
				}
			}

		

			System.out.print("\n\nItem Code: ");
			String itemCode = new Scanner(System.in).next();

			boolean exists = checkIfItemExists(itemCode);

			if (exists) {
				System.out.println("Item ID already exists. Please try a new ID.");
				continue;
			}

			int currentItemIndex = checkAndAddItemCode(itemCode);

			String supplierId = assignToWhichSupplier();
			String category = assignToWhichCategory();

			
			Item[currentItemIndex][1] = supplierId;
			Item[currentItemIndex][2] = category;

			System.out.print("\n\nDescription: ");
			Item[currentItemIndex][3] =new  Scanner(System.in).next();

			System.out.print("Unit Price: ");
			int unitPrice =new  Scanner(System.in).nextInt();
			Item[currentItemIndex][4] = String.valueOf(unitPrice);

			System.out.print("QTY on Hand: ");
			Item[currentItemIndex][5] =new  Scanner(System.in).next();

		

			System.out.print("\nAdded successfully! Do you want to add another Item (Y/N): ");
			char yesOrNo = new Scanner(System.in).next().charAt(0);

			if (yesOrNo == 'Y' || yesOrNo == 'y') {
		 ClearConsole.clearConsole();
				AddItem();
				return;
			} else if (yesOrNo == 'N' || yesOrNo == 'n') {
			 ClearConsole.clearConsole();
				stockManagement();
				return;
			}
		}
	}

	public static boolean checkIfItemExists(String itemCode) {
		for (int i = 0; i < Item.length; i++) {
			if (Item[i][0] != null && Item[i][0].equals(itemCode)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasCategories() {
		for (String category : Categories) {
			if (category != null) {
				return true;
			}
		}
		return false; 
	}

	public static boolean hasSuppliers() {
		for (String[] supplier : supplies) {
			if (supplier != null) {
				return true;
			}
		}
		return false; 
	}

	public static int checkAndAddItemCode(String itemCode) {
		for (int i = 0; i < Item.length; i++) {
			if (Item[i][0] == null) {
				Item[i][0] = itemCode;
				System.out.println("\n\nSupplies List :");
				return i;
			}
		}

		
		int newIndex = Item.length;
		growItemArray();
		Item[newIndex][0] = itemCode;
		System.out.println("Supplies List :");
		return newIndex;
	}

	public static void growItemArray() {
		String[][] temp = new String[Item.length + 1][6];

		for (int i = 0; i < Item.length; i++) {
			for (int j = 0; j < Item[i].length; j++) {
				temp[i][j] = Item[i][j];
			}
		}

		Item = temp;
	}

	public static String assignToWhichSupplier() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("+----------------+---------------+---------------+");
		System.out.println("|       #        | SUPPLIER ID   | SUPPLIER NAME |");
		System.out.println("+----------------+---------------+---------------+");

		for (int i = 0; i < supplies.length; i++) {
			String supplierId = supplies[i][0];
			String supplierName = supplies[i][1];
			System.out.printf("| %-14s | %-13s | %-13s |%n", (i + 1), supplierId, supplierName);
		}

		System.out.println("+----------------+---------------+---------------+");
		System.out.println();

		String selectedSupplier;
		while (true) {
			System.out.print("\nEnter the suppliers number > ");
			int optionNumber = scanner.nextInt();

			if (optionNumber >= 1 && optionNumber <= supplies.length) {
				selectedSupplier = supplies[optionNumber - 1][0];
				System.out.print("\nItem categories :");
				break;
			} else {
				System.out.println("Invalid option number!\n");
				continue;
			}
		}
		return selectedSupplier;
	}

	public static String assignToWhichCategory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("+----------------+---------------+");
		System.out.println("|      #         | CATEGORY      |");
		System.out.println("+----------------+---------------+");
		for (int i = 0; i < Categories.length; i++) {
			System.out.printf("| %-14s | %-13s |%n", (i + 1), Categories[i]);
		}

		System.out.println("+----------------+---------------+");
		System.out.println();
		String selectedCategory;
		while (true) {
			System.out.print("\nEnter the category number > ");
			int optionNumber = scanner.nextInt();

			if (optionNumber >= 1 && optionNumber <= Categories.length) {
				selectedCategory = Categories[optionNumber - 1];
				break;
			} else {
				System.out.println("Invalid option number!\n");
				continue;
			}
		}
		return selectedCategory;
	}
		
		
		
		
	  public static void displayItemsBySupplierWise() {
		
		System.out.println("+-----------------------------------------------------------------------------------------------------------+");
		System.out.println("|                            SEARCH SUPPLIER                                                                |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------+\n");
		
		while(true) {
			System.out.print("\n\nEnter the supplier ID: ");
			String supplierId =new Scanner(System.in).next();

			
			boolean supplierExists = false;
			for (int i = 0; i < supplies.length; i++) {
				if (supplies[i][0] != null && supplies[i][0].equals(supplierId)) {
					supplierExists = true;
					break;
				}
			}

			if (supplierExists) {
				
				String supplierName = getSupplierName(supplierId);
				System.out.println("Supplier name : " + supplierName + "\n\n");
				
			
				System.out.println("------------------------------------------------------------------------------------------------");
				System.out.printf("| %-15s | %-20s | %-15s | %-20s | %-10s |\n", "Item Code", "Description", "Unit Price", "QTY on Hand", "Category");
				System.out.println("------------------------------------------------------------------------------------------------");
				for (int i = 0; i < Item.length; i++) {
					if (Item[i][1] != null && Item[i][1].equals(supplierId)) {
						String itemCode = Item[i][0];
						String description = Item[i][3];
						String unitPrice = Item[i][4];
						String qtyOnHand = Item[i][5];
						String category = Item[i][2];
						System.out.printf("| %-15s | %-20s | %-15s | %-20s | %-10s |\n", itemCode, description, unitPrice, qtyOnHand, category);
					}
				}
				System.out.println("------------------------------------------------------------------------------------------------");
				
				System.out.print(" Search successfully! Do you want another search (Y/N) : ");
				char yesOrNo =new  Scanner(System.in).next().charAt(0); 
				
				if( yesOrNo == 'Y' || yesOrNo == 'y' ) {
						 ClearConsole.clearConsole();
						 displayItemsBySupplierWise();
						continue;
				}
				else if( yesOrNo == 'N' || yesOrNo == 'n' ) {
				 ClearConsole.clearConsole();
					stockManagement();
					return;
				}
				
			} else {
				System.out.println("Supplier ID not found. Do you want another search (Y/N) : ");
				char y = new Scanner(System.in).next().charAt(0); 
				
				if( y == 'Y' || y == 'y' ) {
						continue;
				}
			}
		}
	}
	
	public static String getSupplierName(String supplierId) {
		for (int i = 0; i < supplies.length; i++) {
			if (supplies[i][0] != null && supplies[i][0].equals(supplierId)) {
				return supplies[i][1];
			}
		}
		return "";
	}
	/////////////////////////////////////////////////////////////////////      
    
    
    
    
    
    
    public static void viewItemsByCategory() {

	

	
        System.out.println("+-----------------------------------------------------------------------------------------------------------+");
		System.out.println("|                            VIEW ITEM                                                                      |");
		System.out.println("+-----------------------------------------------------------------------------------------------------------+\n");

		if (!hasCategories()) {
			System.out.println("No item categories found in the system.");
			return;
		}

		for (int i = 0; i < Categories.length; i++) {
			if (Categories[i] != null) {
				String category = Categories[i];
				System.out.println("\n " + category + ":");

				boolean itemsFound = false; 

				for (int j = 0; j < Item.length; j++) {
					if ((Item[j][0] != null) && (Item[j][2].equals(category))) {
						String sid = Item[j][1];
						String itemCode = Item[j][0];
						String description = Item[j][3];
						String price = Item[j][4];
						String qty = Item[j][5];

						itemsFound = true;
						if (itemsFound) {
							System.out.println("------------------------------------------------------------");
							System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-5s |\n", "SID", "CODE", "DESC", "PRICE", "QTY");
							System.out.println("------------------------------------------------------------");
							
							System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-5s |\n", sid, itemCode, description, price, qty);
							System.out.println("------------------------------------------------------------");
						}

					}
				}

			}
		}

		System.out.print("Do you want to go back to Stock Manage Page (Y/N): ");
		char yesOrNo = new Scanner(System.in).next().charAt(0);

		if (yesOrNo == 'Y' || yesOrNo == 'y') {
		 ClearConsole.clearConsole();
			stockManagement();
		} else if (yesOrNo == 'N' || yesOrNo == 'n') {
			System.out.print("Press (Y) anytime to go back to Stock Manage Page: ");
			yesOrNo = new Scanner(System.in).next().charAt(0);

			if (yesOrNo == 'Y' || yesOrNo == 'y') {
			 ClearConsole.clearConsole();
				stockManagement();
			}
		}
	}

	public static void viewItemsByPriceAscending() {
		
	    System.out.println("+-------------------------------------------------------------------------------------------------------------+");
		System.out.println("|                     RANK UNIT PRICE                                                                         |");
		System.out.println("+-------------------------------------------------------------------------------------------------------------+\n\n");


		if (Item[0][0] == null) {
			System.out.println("No items found in the system.");
			return;
		}

		
		int itemCount = 0;
		for (String[] item : Item) {
			if (item[0] != null) {
				itemCount++;
			}
		}

		
		String[][] sortedItems = new String[itemCount][6];

	
		int index = 0;
		for (int i = 0; i < Item.length; i++) {
			if (Item[i][0] != null) {
				for (int j = 0; j < Item[i].length; j++) {
					sortedItems[index][j] = Item[i][j];
				}
				index++;
			}
		}

		// Sort the items using unit price. (using bubble sort)
		for (int i = 0; i < sortedItems.length - 1; i++) {
			for (int j = 0; j < sortedItems.length - i - 1; j++) {
				int price1 = Integer.parseInt(sortedItems[j][4]);
				int price2 = Integer.parseInt(sortedItems[j + 1][4]);

				if (price1 > price2) {
					// Swap items
					String[] temp = sortedItems[j];
					sortedItems[j] = sortedItems[j + 1];
					sortedItems[j + 1] = temp;
				}
			}
		}

		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-5s | %-10s |\n", "SID", "CODE", "DESC", "PRICE", "QTY", "CATEGORY");
		System.out.println("------------------------------------------------------------------------------------");

		
		for (String[] item : sortedItems) {
			String sid = item[1];
			String itemCode = item[0];
			String description = item[3];
			String price = item[4];
			String qty = item[5];
			String category = item[2];

			// Print item details in tabular format
			System.out.printf("| %-10s | %-10s | %-20s | %-10s | %-5s | %-10s |\n", sid, itemCode, description, price, qty, category);
		}

		System.out.println("-------------------------------------------------------------------------------------");
	

		System.out.print(" Do you want to go back to Stock Manage Page   (Y/N) : ");
		char yesOrNo = new Scanner(System.in).next().charAt(0);

		if (yesOrNo == 'Y' || yesOrNo == 'y') {
		 ClearConsole.clearConsole();
			stockManagement();
		} else if (yesOrNo == 'N' || yesOrNo == 'n') {

			System.out.print(" Press (Y) anytime to go back to Stock Manage Page  : ");
			yesOrNo = new Scanner(System.in).next().charAt(0);

			if (yesOrNo == 'Y' || yesOrNo == 'y') {
			 ClearConsole.clearConsole();
				stockManagement();
			}

		}

	}


    
     public static void main(String[] args) {
        loginPage();
    }
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

    
    
    
    
    

