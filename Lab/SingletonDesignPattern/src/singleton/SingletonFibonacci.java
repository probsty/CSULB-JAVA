package singleton;

import java.math.BigInteger;

public class SingletonFibonacci {
    private static SingletonFibonacci m_instance = null;
    BigInteger m_iter = new BigInteger("0");
    BigInteger m_previous = new BigInteger("1");
    BigInteger m_previousPrevious = new BigInteger("1");

    private SingletonFibonacci() {

    }

    public static SingletonFibonacci getFibonacci() {
        if (m_instance == null) {
            m_instance = new SingletonFibonacci();
        }
        return m_instance;
    }

    public BigInteger next() {
        m_iter = new BigInteger(String.valueOf(m_iter.add(new BigInteger("1"))));
        if (m_iter.intValue() == 1) {
            return BigInteger.ZERO;
        }
        else if (m_iter.intValue() < 4) {
            return BigInteger.ONE;
        } else {
            BigInteger result = new BigInteger(String.valueOf(m_previous.add(m_previousPrevious)));
            m_previousPrevious = new BigInteger(String.valueOf(m_previous));
            m_previous = result;
            return  result;
        }
    }

   /* public static int Fibonacci (int input) {
        if (input < 2) {
            return input;
        } else {
            return Fibonacci (input - 1) + Fibonacci (input - 2);
        }
    } */
}
