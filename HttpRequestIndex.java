//Kevin Kot
//CSPS 24500
//SwissArmyKnife Project

public class HttpRequestIndex extends HttpRequest {
   HttpRequestIndex() {
       super();
   }
  
   public Boolean readURL(String urlIn) {
       Boolean returnValue = super.readURL(urlIn);

       for (String line : urlContent) {
           // Makeshift JSON interpreter. Trim extra whitespace, remove beginning and ending curly braces and commas
           line = line.trim();
           line = line.replace("{ \"", "");
           if (line.substring(line.length() - 1).contentEquals(",")) {
               line = line.replace("\" },", "");
           }
           else {
               line = line.replace("\" }", "");
           }
           line = line.replace("\" },", "");
           String lineTokens[] = line.split("\", \"");
          
           // If there are more than 1 token (a line containing more than just '[' or '{', try to decipher each property name and value
           if (lineTokens.length > 1) {
               for (String lineToken : lineTokens) {
                   String parameterTokens[] = lineToken.split("\":\"");
                  
                   // Search for an https:// URL in a parameter value, and download/display any URLs found
                   if (parameterTokens[1].toLowerCase().startsWith("https://")) {
                       HttpRequest entryHttpRequest = new HttpRequest();
                       if (entryHttpRequest.readURL(parameterTokens[1])) {
                           System.out.println(entryHttpRequest.toString());
                       }
                       else {
                           System.out.println("--Unable to access URL: " + parameterTokens[1]);
                       }
                   }
               }
           }
       }
      
       return returnValue;
   }
  public static void main(String[] args) {
        HttpRequest request = new HttpRequest();
        if (request.readURL("https://mustang-index.azurewebsites.net/index.json")) {
            System.out.println(request);
        }    
    }
}