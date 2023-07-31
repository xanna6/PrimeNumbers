package apiotrowska.primenumbers.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeNumberService {

    public List<Integer> findPrimeNumbersLessThan(Integer upperBoundary) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] sieve = new boolean[upperBoundary];

        for (int i = 1; i < sieve.length; i++) {
            sieve[i] = true;
        }
        for (int i = 1; i < Math.sqrt(sieve.length); i++) {
            if(sieve[i]) {
                for(int j = (i+1)*(i+1); j <= sieve.length; j = j+i+1) {
                    sieve[j-1] = false;
                }
            }
        }

        for (int i=1; i < sieve.length; i++) {
            if (sieve[i]) {
                primeNumbers.add(i+1);
            }
        }
        return primeNumbers;
    }
}
