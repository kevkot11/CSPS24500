//Kevin Kot
//CSPS 24500
//SwissArmyKnife Project

public class sak {

   public static void main(String[] args) {      
       //if there are no commands entered, system prints out a message, uses the help command, and then exits the application. 
	   if (args.length < 1) {
            System.out.println("You must enter a command for the application to work. Use the '-Help' command for options");
            Help.printHelp();  
			System.exit(0);
        } 
		
	   //If the Help command is entered. 
	   else if ((args[0].equalsIgnoreCase("-Help"))) {
           System.out.println("Running the Help command...");
		   Help.printHelp();
       }
	   
	   //if the HttpRequest command is entered
       else if ((args[0].equalsIgnoreCase("-HttpRequest"))) {
            if (args.length <2) {
                System.out.println("The -HttpRequest function requires a valid URL as the second parameter.");
            } 
			else {
                String URL = args[1];
                HttpRequest request = new HttpRequest();
                if (request.readURL(URL)) {
                    System.out.println(request);
                }           
            }
       }
	   
	   //if the HttpRequestIndex command is entered. 
	   else if ((args[0].equalsIgnoreCase("-HttpRequestIndex"))){
		   if (args.length <2) {
                System.out.println("The -HttpRequestIndex function requires a valid URL as the second parameter.");
			} 
			else {
                 String URL = args[1];
                 HttpRequestIndex requestIndex = new HttpRequestIndex();
			
           System.out.println("-Executing HttpRequestIndex");

				if (requestIndex.readURL(URL)) {
				// System.out.println(requestIndex);
				}
				else {
               System.out.format("Unable to access requested URL: ", URL);
				}
	   }
   }
}
}