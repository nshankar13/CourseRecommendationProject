import java.util.Comparator;
import java.util.Arrays;

public class BinarySearchCourses 
{
    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOfDept(CollegeCourse[] a, String dept, Comparator<CollegeCourse> comparator)
    {
        Arrays.sort(a, comparator);
        int low = 0;
        int high = a.length - 1;
        int mid = (low + high) / 2;
        int lowest = -1;
        String midDept;
        int comparison;
        
        if (a[low].getDepartment().compareTo(dept) == 0)
        {
            return low;
        }
        
        while (high >= low)
        {
            midDept = a[mid].getDepartment();
            
            comparison = midDept.compareTo(dept);
            if (comparison > 0)
            {
                high = mid - 1;
            }
            else if (comparison < 0)
            {
                low = mid + 1;
            }
            else
            {
                lowest = mid;
                high = mid - 1;
            }
            mid = ((high + low) / 2);
        }
        
       return lowest;
    }
    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOfDept(CollegeCourse[] a, String dept, Comparator<CollegeCourse> comparator)
    {
        Arrays.sort(a, comparator);
        int low = 0;
        int high = a.length - 1;
        int mid = (low + high) / 2;
        int highest = -1;
        String midDept;
        int comparison;
        
        while (high >= low)
        {
            midDept = a[mid].getDepartment();
            
            comparison = midDept.compareTo(dept);
            if (comparison > 0)
            {
                high = mid - 1;
            }
            else if (comparison < 0)
            {
                low = mid + 1;
            }
            else
            {
                highest = mid;
                low = mid + 1;
            }
            mid = (int)((high + low) / 2);
        }
        
      return highest;
    }
    
    
    // unit testing (required)
    public static void main(String[] args)   
    {
        
    }
    
    
    
}
