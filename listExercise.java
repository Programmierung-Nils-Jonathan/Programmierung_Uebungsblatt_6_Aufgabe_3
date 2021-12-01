public class ListExercise {


     public static int skipSum(List list) {
       //TODO
    }



 
    public static List mergesort(List list) {
	//TODO
    }

    /**
     * Merges two sorted lists to one sorted list.
     */
    private static List merge(List first, List second) {
       //TODO
    }

    /**
     * Divides a list of at least two elements into two lists of the same 
     * length (up to rounding).
     */
    private static List[] divide(List list) {
        List[] res = new List[2];
        int length = list.length() / 2;
        res[0] = list.getSublist(length);
        for (int i = 0; i < length; i++) {
            list = list.getNext();
        }
        res[1] = list;
        return res;
    }
    
    /**
     * Creates a list from the given inputs and outputs the sorted list and 
     * the original list afterwards.
     * @param args array of all list elements
     */
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            List list = buildList(0,args);
            System.out.println(mergesort(list));
            System.out.println(list);
        }
    }

    /**
     * Builds a list from the given input array.
     */
    private static List buildList(int i, String[] args) {
        if (i < args.length) {
            return new List(buildList(i + 1,args), Integer.parseInt(args[i]));
        } else {
            return List.EMPTY;
        }
    }
    
}
