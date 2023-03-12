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

    public boolean validate(String sin){
        boolean validSin = true;
        
        // validate SIN using rules in Wikipedia
        //if (sin == null || sin.length()!=9) return false;
        if (sin == null || sin.length()!=9) validSin = false;
        
        // get an array of chars
        char[] sinChars = sin.toCharArray();
        
        // validate the check sum for a SIN
        int total = 0;
        for (int i=0; i<9; i++){
            char c = sinChars[i];
            
            // all characgers must be digits
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
            // System.out.println(i+" "+c+" "+digit+" "+total);
        }
        // if total is a multiple of 10 the sin is valid
        validSin = (total % 10 == 0);
        return validSin;
    }
}

