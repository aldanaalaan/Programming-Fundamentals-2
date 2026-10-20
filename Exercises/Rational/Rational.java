package Exercises.Rational;

/**
 * Rational
 */
public class Rational extends Number implements Comparable {
  private long numerator, divisor;

  public Rational(){
    this(1, 1);
  }

  public Rational(long numerator, long divisor) {
    setNumerator(numerator);
    setDivisor(divisor);
  }

  private long gcd(long n, long d){
    long n1 = Math.abs(n);
    long n2 = Math.abs(d);
    int gcd = 1;

    for (int k = 1; k <= n1 && k <= n2; k++) {
      if (n1 % k == 0 && n2 % k == 0)
        gcd = k;
    }

    return gcd;
  }

  public long getNumerator() {
    return numerator;
  }

  public void setNumerator(long numerator) {
    this.numerator = numerator;
  }

  public long getDivisor() {
    return divisor;
  }

  public double getValue() {
    return numerator / (double) divisor;
  }

  public void setDivisor(long divisor) {
    if (divisor == 0)
      throw new ArithmeticException("Divisor cannot be zero.");
    this.divisor = divisor;
  }

  @Override
  public int compareTo(Object o) {
    if (getValue() > ((Rational) o).getValue())
      return 1;
    if (getValue() < ((Rational) o).getValue())
      return -1;

    return 0;
  }

  @Override
  public int intValue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'intValue'");
  }

  @Override
  public long longValue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'longValue'");
  }

  @Override
  public float floatValue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'floatValue'");
  }

  @Override
  public double doubleValue() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'doubleValue'");
  }
}