public class Employee
{
    private String sin;
    private String name;
    private String position;
    
    public Employee (String sin, String name, String position) throws InvalidSINException{
        
        if (! validate(sin)) 
            throw new InvalidSINException(sin);
            
        // if the sin is not valid exectution is halted here
        this.sin = sin;
        this.name = name;
        this.position = position;
    }
    
    public String getSin(){
        return sin;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPosition(){
        return position;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public void setPosition(String position){
        this.position = position;
    }

    public String toString(){
        return "Employee "+getSin()+", "+getName()+", "+getPosition();
    }

    /*****************************************
    * Description: Checks a SIN number to see if it is valid,
    *               A valid SIN is nine digits in length and
    *               passes the checksum test
    * 
    * @param        String: sin, a SIN number
    * 
    * @return       bollean validSin: true if the SIN passes all the test, false
    *                                   otherwise.
    * ****************************************/
    public boolean validate(String sin){
        boolean validSin = true;
        
        // validate SIN using rules in Wikipedia
        //if (sin == null || sin.length()!=9) return false;
        if (sin == null || sin.length()!=9) validSin = false;
        
        // get an array of chars
        char[] sinChars = sin.toCharArray();
        
        // validate the check sum for a SIN
        int total = 0;
        for (int i = 0; i < sinChars.length; i++){
            char c = sinChars[i];
            
            // all characters must be digits
            if (!Character.isDigit(c)) 
                validSin = false;
            
                
            int digit = Character.getNumericValue(c);
            
            // double every second digit
            if (i%2 == 1) 
                digit *= 2; 
                
            // correction if 10 or more, must be a single digit
            if (digit > 9) 
                digit -= 9;
                
            total += digit;
            //System.out.println(i+" "+c+" "+digit+" "+total);
        }
        // if total is a multiple of 10 the sin is valid
        // if(total % 10 != 0){
            // validSin = false;
        // }
        
        // or
        // use &= bitwise and so that if validSin is 
        // currently false a true % 10 won't make it true
        validSin &= (total % 10 == 0);
        return validSin;
    }
}

