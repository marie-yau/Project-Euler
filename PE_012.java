/*
 * The sequence of triangle numbers is generated by adding the natural numbers. 
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.  
 * The first ten terms would be: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * We can see that 28 is the first triangle number to have over five divisors.
 * What is the value of the first triangle number to have over five hundred divisors?
 *
 * RESULT: 76576500
 */
package pe_012_1;

public class PE_012_1 {
    
    public static void main(String[] args) {
        
        int divisors = 1, number;
        
        
        for(int j = 1; divisors <= 500; j++){
            number = j*(j+1)/2;
            
            int [] exponents = exponents(number);
            
            divisors = 1;
            for(int i = 0; exponents[i] != 0; i++){
                int sum = exponents[i]+1;
                divisors = divisors*sum;
                sum = 0;
            }
            
            if(divisors > 500)
                System.out.println("RESULT "+number+ ", divisors "+divisors);
            
        }
    }
    
    public static int [] exponents (int number){
        int [] exponents = new int [20];
        int count = 0, b = 0;
        int [] primes = primes();
        
        for(int i = 0; i <= 4999; i++){
            if(number % primes[i] == 0){
                while(number % primes[i] == 0){
                    count++;
                    number /= primes[i];
                }
                exponents[b] = count;
                b++;
                count = 0;
            }    
        }
        return exponents;
    }
    
    
    public static int [] primes (){
        int a = 1;
        int [] primes = new int [5000];
        
        primes [0] = 2;
        for(int number = 3; a < 5000; number += 2){
            if(testprime(number)){
                primes[a] = number;
                a++;
            }
        }
        return primes;
    }
    
    public static boolean testprime (int number){
        for(int i = 3; i <= Math.sqrt(number); i += 2){
                if(number % i == 0){
                    return false;
                }    
        }
        return true;
    }
    
}