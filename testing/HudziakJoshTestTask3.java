import cm.CarParkKind;
import cm.Period;
import cm.Rate;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/*
 *
 *  Created by Josh Hudziak on 11/03/2021.
 *
 */

public class HudziakJoshTestTask3 {


    /*
     *  Arrays to test against within Rate()
     */

    ArrayList<Period> reducedPeriods;
    ArrayList<Period> reducedPeriodsCC1;
    ArrayList<Period> reducedPeriodsCC2;
    ArrayList<Period> reducedPeriodsCC3;
    ArrayList<Period> reducedPeriodsCC4;

    ArrayList<Period> normalPeriods;
    ArrayList<Period> normalPeriodsCC1;
    ArrayList<Period> normalPeriodsCC2;
    ArrayList<Period> normalPeriodsCC3;
    ArrayList<Period> normalPeriodsCC4;

    //Test Null Values in Rate()
    BigDecimal b;


    @Before
    public void instantiatePeriods() {
        reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(6, 7));
        normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        normalPeriods.add(new Period(17, 20));

        reducedPeriodsCC1 = new ArrayList<Period>() {{
            add(new Period(2,4));
            add(new Period(18,19));
        }};
        normalPeriodsCC1 = new ArrayList<Period>() {{
            add(new Period(0,2));
            add(new Period(13,17));
            add(new Period(23,24));
        }};

        reducedPeriodsCC2 = new ArrayList<Period>() {{
            add(new Period(0,4));
            add(new Period(23,24));
        }};
        normalPeriodsCC2 = new ArrayList<Period>() {{
            add(new Period(6,23));
        }};

        reducedPeriodsCC3 = new ArrayList<Period>() {{
            add(new Period(0,2));
            add(new Period(13,17));
            add(new Period(23,24));
        }};
        normalPeriodsCC3 = new ArrayList<Period>() {{
            add(new Period(2,4));
            add(new Period(5,12));
            add(new Period(17,19));
        }};

        // (null pointers)
        normalPeriodsCC4 = null;
        reducedPeriodsCC4 = null;

        b = null;
    }

    /*
     *
     *     rate() Unit Tests
     *
     */

    // Test Case #1
    @org.junit.Test
    public void validKind() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 2: normal rate > 0
     */
    @org.junit.Test
    public void normalRateGreaterThanZero() {
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(2.5), BigDecimal.valueOf(1), reducedPeriods, normalPeriods);
    }

    /*
    TEST 3: normalRate == maxInt
     */
    @org.junit.Test
    public void normalRateMaxInt() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(Integer.MAX_VALUE), BigDecimal.valueOf(42), reducedPeriods, normalPeriods);
    }

    /*
    TEST 4: normalRate > reducedRate
     */
    @org.junit.Test
    public void normalRateGreaterThanReducedRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(4), reducedPeriods, normalPeriods);
    }

    /*
    TEST 5: normalRate < 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanZero() throws Exception {
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(-1), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 6: normalRate == 1
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateEqualOne() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(1), BigDecimal.valueOf(1), reducedPeriods, normalPeriods);
    } // Throws exception as reduced !< normal.

    /*
    TEST 7: normalRate == 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateEqualZero() throws Exception  {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(0), BigDecimal.valueOf(1), reducedPeriods, normalPeriods);
    }

    /*
    TEST 8: normalRate < reducedRate
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanReducedRate() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(7), reducedPeriods, normalPeriods);
    }

    /*
    TEST 9: reducedRate > normalRate
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateGreaterThanNormalRate() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(1), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 10: reducedRate == 1
     */
    @org.junit.Test
    public void reducedRateEqualToOne() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(2), BigDecimal.valueOf(1), reducedPeriods, normalPeriods);
    }

    /*
    TEST 11: reducedRate == maxInt - 1
     */
    @org.junit.Test
    public void reducedRateMaxInt() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(Integer.MAX_VALUE), BigDecimal.valueOf(Integer.MAX_VALUE - 1), reducedPeriods, normalPeriods);
    }

    /*
    TEST 12: reducedRate < 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateLessThanZero() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(-1), reducedPeriods, normalPeriods);
    }

    /*
    TEST 13: reducedRate == 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateEqualZero() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(0), reducedPeriods, normalPeriods);
    }
    /*
    TEST 14: reducedRate == normalRate
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateEqualToNormal() throws Exception  {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(2), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 15: reducedPeriods min period
     */
    @org.junit.Test
    public void reducedPeriodMin() {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(0, 1));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 16: reducedPeriods max
     */
    @org.junit.Test
    public void reducedPeriodMax() {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(0, 24));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 17: reducedPeriods within bounds
     */
    @org.junit.Test
    public void reducedPeriodValidPeriod() {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(11, 17));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 18: reducedPeriods no period specified
     */
    @org.junit.Test
    public void reducedPeriodNoPeriodSpecified() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 19: reducedPeriods max number periods
     */
    @org.junit.Test
    public void reducedPeriodMaxPeriods() {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{
            for (int i = 0; i < 24; i++) {
                add(new Period(i, i + 1));
            }
        }};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 20: reducedPeriods start > reducedPeriod end
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodStartGreaterThanEnd() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(10, 1));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 21: reducedPeriods out of bounds
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodOutOfBounds() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(0, 48));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 22: reducedPeriods out of bounds (boundary check)
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodOutOfBoundsOnBoundary() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(0, 25));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 23: reducedPeriods overlap
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodOverlap() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{
            add(new Period(6, 7));
            add(new Period(6, 8));
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 24: reducedPeriods overlap with normalPeriod
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodOverlapWithNormal() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{add(new Period(2, 7));}};
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{add(new Period(6, 10));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 25: reducedPeriods overlap with normalPeriod
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodOverlapWithNormalAlt() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{
            add(new Period(2, 7));
            add(new Period(10, 23));
        }};
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(7, 10));
            add(new Period(10, 11));
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 26: reducedPeriods too many periods
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsTooManyPeriods() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>() {{
            for (int i = 0; i < 25; i++) {
                add(new Period(i, i + 1));
            }
        }};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 27: normalPeriods min range period
     */
    @org.junit.Test
    public void normalPeriodMin() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{add(new Period(0, 1));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 28: normalPeriods max range period
     */
    @org.junit.Test
    public void normalPeriodMax() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{add(new Period(0, 24));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 29: normalPeriods within bounds
     */
    @org.junit.Test
    public void normalPeriodValidPeriod() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{add(new Period(11, 17));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 30: normalPeriods max number periods
     */
    @org.junit.Test
    public void normalPeriodsMaxPeriods() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            for (int i = 0; i < 24; i++) {
                add(new Period(i, i + 1));
            }
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 31: normalPeriods start > normalPeriod end
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodStartGreaterThanEnd() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(10, 1));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 32: normalPeriods out of bounds
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOutOfBounds() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(0, 48));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 33: normalPeriods out of bounds (boundary check)
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOutOfBoundsOnBoundary() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(0, 25));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 34: normalPeriods overlap
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOverlap() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(2, 4));
            add(new Period(3, 5));
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 35: normalPeriods too many periods
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsTooManyPeriods() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            for (int i = 0; i < 25; i++) {
                add(new Period(i, i + 1));
            }
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 36: Free periods
     */
    @org.junit.Test
    public void onlyFreePeriod() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 37: normalPeriods null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsNullPointer() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriodsCC4);
    }

    /*
    TEST 38: reducedPeriods null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsNullPointer() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC4, normalPeriods);
    }

    /*
    TEST 39: normalPeriods and reducedPeriods null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void periodsNullPointer() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC4, normalPeriodsCC4);
    }

    /*
    TEST 40: normalRate is null
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateNull() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, b, BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 41: reducedRate is null
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedRateNull() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), b, reducedPeriods, normalPeriods);
    }

    /*
    TEST 42: normalRate and reducedRate is null
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void ratesNull() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, b, b, reducedPeriods, normalPeriods);
    }
    /*
    TEST 43: reducedPeriods contain null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodsContainNull() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{add(null);}};
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 44: normalPeriods contain null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsContainNull() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(null);}};
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 45: normalPeriods and reducedPeriods contain null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void periodsListsContainNull() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{add(null);}};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(null);}};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
    }

    /*
    TEST 46: normalPeriods and reducedPeriods Pointer overlap
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCase13() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{
            add(new Period(10, 12));
            add(new Period(17, 21));
        }};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(10,12));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }

    /*
        TEST 47: reduced Period start < 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodStartLessThanZero() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{
            add(new Period(-1, -1));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }

    /*
        TEST 48: reduced Period end < 0
   */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodEndLessThanZero() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{
            add(new Period(2, -1));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }

    /*
     TEST 49: normal Period Start < 0
    */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodStartLessThanZero() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(-6,12));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }
    /*
     TEST 50: normal Period end < 0
    */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodEndLessThanZero() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(6,-5));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }
    /*
     TEST 51: reduced Period start > 24
  */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodStartGreaterThan24() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{
            add(new Period(27, 12));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }

    /*
        TEST 52: reduced Period end > 24
   */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriodEndGreaterThan24() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{
            add(new Period(7, 27));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }
    /*
        TEST 52: reduced Period end > 24
   */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducedPeriod00() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{
            add(new Period(2, -6));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }

    /*
     TEST 53: normal Period End and Start > 24
    */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodStartGreaterThan24() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(27,28));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);

    }

    /*
    TEST 54: multiple normal period overlaps
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void multiplePeriodOverlaps() throws Exception {
        ArrayList<Period> reducedPeriods = new ArrayList<Period>(){{ }};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(10,13));
            add(new Period(11, 15));
            add(new Period(13, 20));
        }};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(10), BigDecimal.valueOf(8), reducedPeriods, normalPeriods);
    }



    /*
     *
     *     duration() Unit Tests
     *
     */

    /*
        TEST 1: duration() is valid
     */
    @org.junit.Test
    public void durationValid() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC1, normalPeriodsCC1);
        Period periodStay = new Period(0,1);
        assertEquals(1, periodStay.duration());
    }
    /*
        TEST 2: duration() is not valid
     */
    @org.junit.Test
    public void durationNotValid() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC1, normalPeriodsCC1);
        Period periodStay = new Period(0,8);
        assertNotEquals(1, periodStay.duration());

    }

    /*
     *
     *     calculate() Unit Tests
     *
     */

    /*
      TEST 1: first period, normal period boundary
       */
    @org.junit.Test
    public void firstPeriodNormalPeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC1, normalPeriodsCC1);
        Period periodStay = new Period(0,1);
        assertEquals(BigDecimal.valueOf(3), rt.calculate(periodStay));

    }

    /*
    TEST 2: last period, normal period boundary
     */
    @org.junit.Test
    public void lastPeriodNormalPeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC1, normalPeriodsCC1);
        Period periodStay = new Period(23,24);
        assertEquals(BigDecimal.valueOf(3), rt.calculate(periodStay));

    }

    /*
    TEST 3: first period, reduced period boundary
     */
    @org.junit.Test
    public void firstPeriodReducedPeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC2, normalPeriodsCC2);
        Period periodStay = new Period(0,1);
        assertEquals(BigDecimal.valueOf(2), rt.calculate(periodStay));

    }

    /*
    TEST 4: last period, reduced period boundary
     */
    @org.junit.Test
    public void lastPeriodReducedPeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC2, normalPeriodsCC2);
        Period periodStay = new Period(23,24);
        assertEquals(BigDecimal.valueOf(2), rt.calculate(periodStay));

    }

    /*
    TEST 5: arbitrary period - normal rate
     */
    @org.junit.Test
    public void arbitraryPeriodNormalRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC2, normalPeriodsCC2);
        Period periodStay = new Period(14,17);
        assertEquals(BigDecimal.valueOf(9), rt.calculate(periodStay));
    }

    /*
    TEST 6: first period in normal period
     */
    @org.junit.Test
    public void firstNormalPeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(1), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(2,4);
        assertEquals(BigDecimal.valueOf(8), rt.calculate(periodStay));
    }

    /*
    TEST 7: last period in normal period
     */
    @org.junit.Test
    public void lastNormalPeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(1), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(17,19);
        assertEquals(BigDecimal.valueOf(8), rt.calculate(periodStay));
    }

    /*
    TEST 8: arbitrary period - reduced rate
     */
    @org.junit.Test
    public void arbitraryPeriodReducedRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(1), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(14,17);
        assertEquals(BigDecimal.valueOf(3), rt.calculate(periodStay));
    }

    /*
    TEST 9: normal period and free period
     */
    @org.junit.Test
    public void normalPeriodAndFreePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(18,20);
        assertEquals(BigDecimal.valueOf(3), rt.calculate(periodStay));
    }

    /*
    TEST 10: normal period and reduced period
     */
    @org.junit.Test
    public void normalPeriodAndReducedPeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(1,3);
        assertEquals(BigDecimal.valueOf(5), rt.calculate(periodStay));
    }

    /*
    TEST 11: reduced period and free period
     */
    @org.junit.Test
    public void reducedPeriodAndFreePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(12,14);
        assertEquals(BigDecimal.valueOf(2), rt.calculate(periodStay));
    }

    /*
    TEST 12: normal, reduced and free period
     */
    @org.junit.Test
    public void normalReducedFreePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(16,20);
        assertEquals(BigDecimal.valueOf(8), rt.calculate(periodStay));
    }

    /*
    TEST 13: Free period (no charge)
     */
    @org.junit.Test
    public void freePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(20,23);
        assertEquals(BigDecimal.valueOf(0), rt.calculate(periodStay));
    }

    /*
    TEST 14: New Spec Visitor Rate
    */
    @org.junit.Test
    public void visitorRateAll() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
        Period periodStay = new Period(7,20);
        assertEquals(BigDecimal.valueOf(3.5), rt.calculate(periodStay));
    }

    /*
    TEST 15: New Spec Visitor Rate
    */
    @org.junit.Test
    public void visitorRateFirstFree() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
        Period periodStay = new Period(4,7);
        assertEquals(BigDecimal.valueOf(0), rt.calculate(periodStay));
    }

    /*
    TEST 16: New Spec Management Rate
     */
    @org.junit.Test
    public void managementRate() {
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
        Period periodStay = new Period(5,8);
        assertEquals(BigDecimal.valueOf(3), rt.calculate(periodStay));
    }

    /*
    TEST 17: New Spec Student Rate
     */
    @org.junit.Test
    public void studentRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
        Period periodStay = new Period(7,19);
        assertEquals(BigDecimal.valueOf(8.5), rt.calculate(periodStay));
    }

    /*
    TEST 18: New Spec Staff Rate
     */
    @org.junit.Test
    public void staffRate() {
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducedPeriods, normalPeriods);
        Period periodStay = new Period(4,19);
        assertEquals(BigDecimal.valueOf(16), rt.calculate(periodStay));
    }

}

