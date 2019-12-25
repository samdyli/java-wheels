package utils;

/**
 * @author gexiaochuan
 * @date 2019/12/25 17:51 Random Utils
 */
public class RandomUtils {

  /**
   * Return [include,exclude) random value
   *
   * @param include left value(include)
   * @param exclude right value (exclude)
   * @return random value in [include,exclude)
   */
  public static double rangeRandom(double include, double exclude) {
    if (exclude < include) {
      throw new IllegalArgumentException("exclude must great than or equal include");
    }
    return Math.random() * (exclude - exclude) + include;
  }

  /**
   * Return probabilistic random value
   * <br>Generate value distributed between {@code startValue} and
   * {@code value}with a {@code lessThanRation} probability
   * <br>and distributed between {@code value}
   * and {@code endValue}with a 1-{@code lessThanRation} probability
   *
   * @param startValue startValue
   * @param value value
   * @param endValue endValue
   * @param lessThanRatio lessThanRatio
   */
  public static double probRandom(double startValue, double value, double endValue,
      double lessThanRatio) {
    double firstRandom = Math.random();
    return Double.compare(firstRandom, lessThanRatio) <= 0 ? rangeRandom(startValue, value)
        : rangeRandom(value, endValue);
  }
}
