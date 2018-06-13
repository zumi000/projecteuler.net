import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

//#1
//#3 does not work
//#4
//#21
//#52
//#12
//#41
//#7
//#15

public class ProjectEuler {
    public int Multiplesof3and5(int x) {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            if (i % 3 == 0) {
                sum += i;
            } else if (i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for (; ; ) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public void LargestPrimeFactor(BigInteger x) {
        BigInteger bix = new BigInteger(String.valueOf(x));
        BigInteger bi0 = new BigInteger("0");
        BigInteger bi2 = new BigInteger("2");
        BigInteger bi3 = new BigInteger("3");

        while (bix.mod(bi2) == bi0) {
            System.out.print(2 + " ");
            bix.divide(bi2);
        }
        /*
        for (BigInteger i = bi3; bi3 <= ProjectEuler.sqrt(bix); i+= bi2)
        {
            // While i divides n, print i and divide n
            while (x.mod(i) == bi0)
            {
                System.out.print(i + " ");
                bix.divide(i);
            }
        }
        if (x > 2)
            System.out.print(x);
            */
    }

    public void LargestPalindromeProduct(int digits) {
        for (int i = (int) Math.pow(10, digits) - 1; i > 0; i--) {
            for (int j = (int) Math.pow(10, digits) - 1; j >= i; j--) {
                String number = String.valueOf(i * j);
                String number2 = new StringBuilder(number).reverse().toString();

                if (number.equals(number2) && number.length() == digits * 2) {
                    System.out.println(number);
                }
            }
        }
    }

    public int AmicableNumbers(int x) {
        int amic = 1;
        for (int i = 2; i < x / 2 + 1; i++) {
            if (x % i == 0) {
                amic += i;
            }
        }
        return amic;

    }

    public void PermutedMultiples() {
        int x = 1;
        while (true) {
            String regex = Regex.stringToRegex(String.valueOf(x));
            if (String.valueOf(x * 6).matches(regex)) {
                if (String.valueOf(x * 2).matches(regex) && String.valueOf(x * 3).matches(regex) &&
                        String.valueOf(x * 4).matches(regex) && String.valueOf(x * 5).matches(regex)) {
                    System.out.println(x);
                    break;
                } else {
                    System.out.println(x);
                    x++;
                }
            } else {
                System.out.println(x);
                x++;
            }
        }
    }

    public void HighlyDivisibleTriangularNumber() {
        int x = 1;
        int counter = 1;
        while (true) {
            ArrayList<Integer> divisors = new ArrayList<>();
            for (int i = 1; i < x / 2 + 1; i++) {
                if (x % i == 0) {
                    divisors.add(i);
                }
            }
            divisors.add(x);

            counter++;
            if (divisors.size() >= 500) {
                System.out.println(counter-1 + " " + x);
                System.out.println(divisors.size());
                System.out.println(divisors);

                break;
            } else if (divisors.size() > 200){
                System.out.println(counter-1 + " " + x);
                System.out.println(divisors.size());
                System.out.println(divisors);
                x+=counter;
            } else {
                System.out.println(counter-1 + " " + x);
                x+=counter;
            }
        }
    }

    private static ArrayList<Integer> allPrimes = new ArrayList<>();
    public static ArrayList<String> permutated = new ArrayList<>();

    public static ArrayList<String> perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            permutated.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
        return permutated;
    }

    public void isPrime () {
        for (int i = 0; i < permutated.size(); i++) {
            int test = Integer.parseInt(permutated.get(i));
            boolean isPrime = true;
            if (test % 2 == 0) {
                isPrime = false;
            } else {
                for (int j = 3; j*j <= test; j += 2) {
                    if (test % j == 0)
                isPrime = false;
                }
            }
            if (isPrime) {allPrimes.add(test);}
        }
    }

    public void PandigitalPrime () {
        perm1("", "1234567");
        isPrime();
        Collections.sort(allPrimes, new IntegerComparator());
        System.out.println(allPrimes.get(0));
    }

    public static ArrayList<String> perm2(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            StringBuffer sb = new StringBuffer("987654");
            permutated.add(sb.append(prefix).toString());
        }
        else {
            for (int i = 0; i < n; i++)
                perm2(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
        return permutated;
        }

    public void PandigitalPrime2 () {
        perm2("", "320");
        perm2("", "310");
        isPrime();
        Collections.sort(allPrimes, new IntegerComparator());
        System.out.println(allPrimes.get(0));
    }

    public void foundPrime (Integer ordinal) {
        int ordCount = 1;
        for (int test = 3; ordCount <= ordinal; test++) {
            boolean isPrime = true;
            if (test % 2 == 0) {
                isPrime = false;
            } else {
                for (int j = 3; j * j <= test; j += 2) {
                    if (test % j == 0)
                        isPrime = false;
                }
            }
            if (isPrime) {
                ordCount++;
                if (ordCount == ordinal) {
                    System.out.println(ordinal + ". prime number is: " + test);
                }
            }
        }
    }

    public BigInteger factorial(String num) {
        BigInteger n = new BigInteger(num);
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else if (n.compareTo(BigInteger.ZERO) == 1) {
            BigInteger factorial = BigInteger.ONE;
            for (BigInteger i = BigInteger.ONE; i.compareTo(n) != 1; i = i.add(BigInteger.ONE)) {
                factorial = factorial.multiply(i);
            }
            return factorial;
        } else {
            System.out.println("n must be a non-negative number.");
            return BigInteger.ZERO;
        }
    }

    public void LatticePaths (String mm, String nn) {
        // counts different routs from top left into right bottom corner
        // (m + n)! / (m! * n!)
        BigInteger m = new BigInteger(mm);
        BigInteger n = new BigInteger(nn);
        BigInteger a = factorial(m.add(n).toString());
        BigInteger b = factorial(m.toString()).multiply(factorial(n.toString()));
        System.out.println(a.divide(b));
    }


        public static void main(String[] args) {
        ProjectEuler pe = new ProjectEuler();
        System.out.println(pe.Multiplesof3and5(1000)); //#1
        //pe.LargestPrimeFactor(600851475143); //#3 does not work
        pe.LargestPalindromeProduct(3); //#4

        ArrayList<Integer> amic = new ArrayList<>();
        int amicSum = 0;
        for (int i = 1; i <= 10000; i++) {

            if (i == pe.AmicableNumbers(pe.AmicableNumbers(i)) && //#21
                pe.AmicableNumbers(i) != i ) {
                amic.add(i);
                amicSum += i;
            }
        }
        System.out.println(amicSum); //#21

        pe.PermutedMultiples(); //#52
        pe.HighlyDivisibleTriangularNumber(); //#12
        pe.PandigitalPrime(); //#41
        //pe.PandigitalPrime2(); //another problem :)
        pe.foundPrime(10001); //#7
        pe.LatticePaths("20","20"); //#15
    }


}
