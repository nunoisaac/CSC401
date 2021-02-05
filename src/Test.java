import java.util.Iterator;

public class Test {
    public static void main(String[] args)
    {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.addFirst(1);
        myList.addFirst(2);
        myList.addLast(3);
        myList.addFirst(4);
        myList.addFirst(5);
        System.out.println(myList);
        System.out.println("List size: "+myList.size());
        System.out.println("indexOf 1: "+myList.indexOf(1));
        System.out.println("indexOf 10: "+myList.indexOf(10));
        System.out.println("Add 6 at index 3");
        myList.add(3,6);
        System.out.println(myList);
        System.out.println("List size: "+myList.size());
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("Add 7 at index 0");
        myList.add(0,7);
        System.out.println(myList);
        System.out.println("List size: "+myList.size());
        //System.out.println("Tail of LL: "+myList.tail);
        //myList.add(-1,7); index out of bounds
        System.out.println("Add 8 at index 7");
        //myList.add(7,8); index out of bounds
        System.out.println(myList);
        System.out.println("Contains 6? "+myList.contains(6));
        System.out.println("Get element at index 6: "+myList.get(6));
        System.out.println("Get element at index 0: "+myList.get(0));
        System.out.println("Adding 20 to end of list: "+myList.offer(20));
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("Adding 15 to end of list: "+myList.offer(15));
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println("Removing first 2 element from list: ");
        myList.remove();
        myList.remove();
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println(myList);
        System.out.println("Removing index 3");
        myList.remove(3);
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println(myList);
        System.out.println("removeLast");
        myList.removeLast();
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println("Removing index 4");
        myList.remove(4);
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println("set 33 at index 2");
        myList.set(2,33);
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        myList.set(0,31);
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println("set 34 at index 3");
        myList.set(3,34);
        System.out.println(myList);
        //System.out.println("Tail of LL: "+myList.tail);
        System.out.println("List size: "+myList.size());
        System.out.println("printing list using toString: \n"+myList);

        System.out.println("Printing list using the iterator");
        Iterator<Integer> itr = myList.iterator();
        while(itr.hasNext())
        {
            System.out.print(itr.next());
            System.out.print(",");
        }
        System.out.println("\nPrinting list using the iterator with enhanced for loop");
        for (Integer integer : myList) {
            System.out.print(integer);
            System.out.print(",");
        }
        System.out.println("\nEnd");

        System.out.println("clearing list: ");
        myList.clear();
        System.out.println("Printing list:");
        System.out.println(myList);
        System.out.println("List size: "+myList.size());






        LinkedList<String> list = new LinkedList<>();
        list.add("tom");
        list.addFirst("jerry");
        list.add("Bugs");
        System.out.println(list);
        System.out.println("Does list contain Bugs? "+list.contains("Bugs"));
        //list.remove();
        //list.remove(2);
        //System.out.println(list);
        //System.out.println("removing using poll: "+list.poll());
        System.out.println(list);
        //list.reverseIterate();
        list.reverseOrder();
        System.out.println("Printing list in reverse order: \n"+list);



        LinkedList<Integer> list0 = new LinkedList<>();
        list0.add(1);
        list0.add(2);
        list0.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);



        LinkedList<LinkedList<Integer>> adj = new LinkedList<>();
        adj.add(list0);
        adj.add(list2);
        adj.add(list3);

        int index=0;
        for (LinkedList<Integer> integers : adj) {
            System.out.print("Layer ["+index+"]: ");
            for (Integer integer : integers) {
                System.out.print(integer);
                System.out.print(", ");
            }
            System.out.println();
            index++;
        }

        Iterator<LinkedList<Integer>> itr3 = adj.iterator();
        while(itr3.hasNext())
        {
            Iterator<Integer> itr4 = itr3.next().iterator();
            while(itr4.hasNext())
            {
                System.out.print(itr4.next()+" ");
            }
            System.out.println();
        }
        System.out.println("Printed with while loop");
        System.out.println(list0);
        System.out.println("Removing: "+list0.remove());
        System.out.println(list0);
        System.out.println("List size: "+list0.size());
        System.out.println("Removing: "+list0.remove());
        System.out.println(list0);
        System.out.println("List size: "+list0.size());
        System.out.println("Removing:last "+list0.remove());
        System.out.println(list0);
        System.out.println("List size: "+list0.size());




    }
}
