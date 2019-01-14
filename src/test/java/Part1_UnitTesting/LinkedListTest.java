package Part1_UnitTesting;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    public LinkedListTest(){
    }

    @BeforeClass
    public static void setUpClass(){
    }

    @AfterClass
    public static void breakDownClass(){
    }


    @Test
    public void testNextBeingNull(){
        ILinkedList<Integer> list = new ILinkedList<>(5);
        System.out.println("1. Testing the next value is null.");
        Assert.assertEquals(null, list.next());
    }// Test of the next method.

    @Test
    public void nextWithNextBeingANumber() {
        ILinkedList<Integer> list = new ILinkedList<>(5);
        list.setNext(new ILinkedList<Integer>(4));
        Integer temp = list.next().get();
        System.out.println("2. The next value should be 4, the actual value is: " + temp);
        Assert.assertTrue(4 == temp);
    }
    @Test
    public void lastWithOneValue(){
        ILinkedList<Integer> list = new ILinkedList<>(5);
        Integer temp = list.last().get();
        System.out.println("3. The last value should be 5, the actual value is: " + temp);
        Assert.assertTrue(temp == 5);
    }

    @Test
    public void lastWithMoreValues(){
        ILinkedList<Integer> list = new ILinkedList<>(10);
        list.append(new ILinkedList<Integer>(2));
        list.append(new ILinkedList<Integer>(7));
        Integer temp = list.last().get();
        System.out.println("4. The last value should be 7, the actual value is: " + temp);
        Assert.assertTrue(temp == 7);
    }

    @Test
    public void afterAtRange0(){
        ILinkedList<Integer> list = new ILinkedList<>(8);
        list.append(new ILinkedList<Integer>(2));
        list.append(new ILinkedList<Integer>(7));
        list.append(new ILinkedList<Integer>(9));
        list.append(new ILinkedList<Integer>(10));
        Integer temp = list.after(0).get();
        System.out.println("5. The after value at 0 should be 8, the actual value is: " + temp);
        Assert.assertTrue(temp == 8);
    }

    @Test
    public void afterAtRange3(){
        ILinkedList<Integer> list = new ILinkedList<>(8);
        list.append(new ILinkedList<Integer>(2));
        list.append(new ILinkedList<Integer>(7));
        list.append(new ILinkedList<Integer>(9));
        list.append(new ILinkedList<Integer>(10));
        Integer temp = list.after(3).get();
        System.out.println("6. The after value at 3 should be 9, the actual value is: " + temp);
        Assert.assertTrue(temp == 9);
    }

    @Test
    public void detachFromNullNext(){
        ILinkedList<Integer> list = new ILinkedList<>(5);
        ILinkedList<Integer> temp = list.detach();
        System.out.println("7. Testing if the detach of 1 value is null the next value.");
        Assert.assertTrue(temp == null);
        Assert.assertTrue(list.next() == null);
    }

    @Test
    public void detachWithValueNext(){
        ILinkedList<Integer> list = new ILinkedList<>(5);
        list.append(new ILinkedList<Integer>(7));
        ILinkedList<Integer> temp = list.detach();
        System.out.println("8. The detached value is 7, the actual value is: " + temp.get() + ". Also the next value is null.");
        Assert.assertTrue(temp.get() == 7);
        Assert.assertTrue(list.next() == null);
    }

    @Test
    public void getNullValue(){
        ILinkedList<Integer> list = new ILinkedList<>();
        System.out.println("9. The value of get is null.");
        Assert.assertTrue(list.get() == null);
    }

    @Test
    public void getRealValue(){
        ILinkedList<Integer> list = new ILinkedList<>(10);
        System.out.println("10. The value is 10, the actual value is: " + list.get());
        Assert.assertTrue(list.get() == 10);
    }

    @Test
    public void setNull(){
        ILinkedList<Integer> list = new ILinkedList<>();
        list.set(3);
        System.out.println("11. The list is null, I added 3, the value is: " + list.get());
        Assert.assertTrue(list.get() == 3);
    }

    @Test
    public void setWithValue(){
        ILinkedList<Integer> list = new ILinkedList<>(5);
        list.set(10);
        System.out.println("12. The list has 5, I added 10, the value is: " + list.get());
        Assert.assertTrue(list.get() == 10);
    }

    @Test
    public void setNextNull(){
        ILinkedList<Integer> list = new ILinkedList<>(11);
        list.setNext(new ILinkedList<>(4));
        System.out.println("13. The list has 11, I added 4 after 11, the list is: " + list.get() + ", " + list.next().get());
        Assert.assertTrue(list.next().get() == 4);
    }

    @Test
    public void setNextWithValue(){
        ILinkedList<Integer> list = new ILinkedList<>(11);
        list.append(new ILinkedList<>(4));
        list.append(new ILinkedList<>(3));
        list.next().setNext(new ILinkedList<>(15));
        System.out.println("14. The list has 11, add 4, then add 3, then set the value after 4 to 15. The list should be 11, 4, 15. The actual list is:  " + list.get() + ", " + list.next().get() + ", " + list.last().get());
        Assert.assertTrue(list.last().get() == 15);
    }

    @Test
    public void appendNullNext(){
        ILinkedList<Integer> list = new ILinkedList<>(10);
        list.append(new ILinkedList<>(11));
        System.out.println("15. The list has 10 in it, it is appended with 11. The actual list is: " + list.get() + ", " + list.last().get());
        Assert.assertTrue(list.last().get() == 11);
    }

    @Test
    public void appendWithValueNext(){
        ILinkedList<Integer> list = new ILinkedList<>(10);
        list.setNext(new ILinkedList<>(11));
        list.append(new ILinkedList<>(25));
        System.out.println("16. The list has 10 and 11 in it, it is appended with 25. The actual list is: " + list.get() + ", " + list.next().get() + ", " + list.last().get());
        Assert.assertTrue(list.last().get() == 25);
    }

    @Test
    public void insertNullNext(){
        ILinkedList<Integer> list = new ILinkedList<>(10);
        list.insert(new ILinkedList<>(5));
        System.out.println("17. The list has 10 in it, i insert 5 before 10. The actual list is: " + list.get() + ", " + list.last().get());
        Assert.assertTrue(list.get() == 5);
        Assert.assertTrue(list.next().get() == 10);
    }

    @Test
    public void insertWithValueNext(){
        ILinkedList<Integer> list = new ILinkedList<>(10);
        list.setNext(new ILinkedList<>(15));
        list.insert(new ILinkedList<>(5));
        System.out.println("18. The list has 10 and 15 in it, i insert 5 before 10. The actual list is: " + list.get() + ", " + list.next().get() + ", " + list.last().get());
        Assert.assertTrue(list.get() == 5);
        Assert.assertTrue(list.next().get() == 10);
        Assert.assertTrue(list.last().get() == 15);
    }

}
