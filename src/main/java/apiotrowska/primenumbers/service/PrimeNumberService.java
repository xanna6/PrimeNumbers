package apiotrowska.primenumbers.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeNumberService {

    public List<Integer> findPrimeNumbersLessThan(Integer upperBoundary) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] sieve = new boolean[upperBoundary];

        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }
        for (int i = 2; i < Math.sqrt(upperBoundary); i++) {
            if(sieve[i]) {
                for(int j = (i*i); j < upperBoundary; j = j+i) {
                    sieve[j] = false;
                }
            }
        }

        for (int i=2; i < sieve.length; i++) {
            if (sieve[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
