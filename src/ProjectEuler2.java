import java.util.ArrayList;
import java.util.HashMap;

public class ProjectEuler2 {

    public void SummationOfPrimes (int num) {
        long sum = 2;
        for (int i = 3; i < num; i++) {
            boolean isPrime = true;
            if (i % 2 == 0) {
                isPrime = false;
            } else {
                for (int j = 3; j*j <= i; j += 2) {
                    if (i % j == 0)
                        isPrime = false;
                }
            }
            if (isPrime) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public void SumSquareDifference (int num) {
        int sum = 0;
        int sumOfSquare = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
            sumOfSquare += Math.pow(i, 2);
        }
        System.out.println((int)Math.pow(sum, 2) - sumOfSquare);
    }

    public void SpecialPythagoreanTriplet (int num) {
        for (int i = 1; i < 499; i++) {
            for (int j = i+1; i+j < 1000; j++) {
                if (Math.sqrt(i*i + j*j) == 1000-j-i) {
                    System.out.println(i + " * " + j + " * " + (1000-j-i) + " = "+ (i*j*(1000-j-i)));
                    break;
                }
            }
        }
    }

    public void LargestProductInASeries () {
        ArrayList<String> splitted = new ArrayList<>();
        String number = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        int maxValueOfSequence = 0;
        for (int i = 0; i < number.length() - 12; i++) {
            String sequence = number.subSequence(i, i + 13).toString();
            int valueOfSequence = 1;
            for (int j = 0; j < sequence.length(); j++) {
                 valueOfSequence *= Character.getNumericValue(sequence.charAt(j));
            }
            if (valueOfSequence > maxValueOfSequence) {
                maxValueOfSequence = valueOfSequence;
                System.out.println(maxValueOfSequence);
                System.out.println(sequence);
            }
        }
    }

    public void SmallestMultiple (int number) {
        HashMap<Integer, Integer> smallestMultiple = new HashMap<>();
        for (int i = 2; i <= number; i++) {
            HashMap<Integer, Integer> primes = GetPrimes(i);
            for (int prime : primes.keySet()) {
                if (!smallestMultiple.keySet().contains(prime)) {
                    smallestMultiple.put(prime, 1);
                }
                else {
                    if (primes.get(prime) > smallestMultiple.get(prime)) {
                        smallestMultiple.put(prime, primes.get(prime));
                    }
                }
            }
        }
        int pow = 1;
        for (int primeFactor : smallestMultiple.keySet()) {
            pow *= Math.pow(primeFactor, smallestMultiple.get(primeFactor));
        }
        System.out.println(smallestMultiple);
        System.out.println("A legkisebb szám, ami 1-től " + number + "-ig minden számmal osztható: " + pow);
    }

    public HashMap<Integer, Integer> GetPrimes (int number){
        HashMap<Integer, Integer> primeFactorsWithpowers = new HashMap<>();
        while (number % 2 == 0) {
            if (!primeFactorsWithpowers.keySet().contains(2)) {
                primeFactorsWithpowers.put(2, 1);
            } else {
                primeFactorsWithpowers.put(2, (primeFactorsWithpowers.get(2) + 1));
            }
            number /= 2;
        }
        for (int i = 3; i * i <= number; i = i + 2) {
            while (number % i == 0) {
                if (!primeFactorsWithpowers.keySet().contains(i)) {
                    primeFactorsWithpowers.put(i, 1);
                } else {
                    primeFactorsWithpowers.put(i, (primeFactorsWithpowers.get(i) + 1));
                }
                number /= i;
            }
        }
        if (number > 2) {
            primeFactorsWithpowers.put(number, 1);
        }
        System.out.println(primeFactorsWithpowers);
        return primeFactorsWithpowers;
    }



    public static void main(String[] args) {
        ProjectEuler2 pe2 = new ProjectEuler2();
        //pe2.LargestProductInASeries(); //#8 does not match with the solution on the page ???
        //pe2.SmallestMultiple(20); //#5
        //pe2.SpecialPythagoreanTriplet(1000); //#9
        //pe2.SumSquareDifference(100); //#6
        //pe2.SummationOfPrimes(2000000); //#10
    }
}

