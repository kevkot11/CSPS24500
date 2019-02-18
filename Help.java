//Kevin Kot
//CSPS 24500
//SwissArmyKnife Project

class Help {
    public static void printHelp() { 
        System.out.println("\nThis command supplies a list of commands active in this application. Format follows the name + description of the command, and followed underneath is an example.");
        
		//Explanation of the help command
		System.out.println("\nHelp: Provides help information from this application."); 
		System.out.println("java sak -help");
		
		//Explanation of the HttpRequest command
        System.out.println("\nHttpRequest [URL]: Takes a URL as input and stores the data into an ArrayList of String.");
        System.out.println("java sak -HttpRequest https://www.lewisu.edu/index.htm");
		
		//Explanation of the HttpRequestIndex command
		System.out.println("\nHttpRequestIndex [URL]: Takes in URL and opens the JSON file. The contents of the file are then attempted to be displayed on the console.");
        System.out.println("java sak -HttpRequest     ");
    }
}