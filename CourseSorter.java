import java.util.Comparator;
import java.util.Arrays; 

public class CourseSorter
{
    private CollegeCourse[] courses; // array of courses that CourseSelector will sort through
    
    public CourseSorter(CollegeCourse[] courses)
    {
        this.courses = courses; 
    }
    
    public CollegeCourse[] allCoursesInDept(String department)
    {
        Comparator<CollegeCourse> deptComparison = CollegeCourse.byDepartmentOrder();
        
        int starting = BinarySearchCourses.firstIndexOfDept(courses, department, deptComparison);
        int ending = BinarySearchCourses.lastIndexOfDept(courses, department, deptComparison);
        
        int size = (ending - starting) + 1;
        CollegeCourse[] inDept = new CollegeCourse[size];
        
        for (int i = 0; i < size; i++)
        {
            inDept[i] = courses[i + starting];
        }
        
        return inDept;
    } 
    
    // for testing purposes
    public static void main(String[] args)
    {
        /*
        CollegeCourse[] crs = new CollegeCourse[5];
        crs[0] = new CollegeCourse("AAS 201", "African American Studies", 2.71, 3.43, 3.67, 3.31, 3.00);
        crs[1] = new CollegeCourse("AAS 353", "African American Studies", 4.60, 4.44, 4.10, 4.60, 4.33);
        crs[2] = new CollegeCourse("CBE 245", "Chemical and Biological Engineering", 3.36, 3.11, 3.43, 3.05, 2.98);
        crs[3] = new CollegeCourse("CLA 244", "Classics", 4.17, 4.33, 4.25, 4.27, 4.33);
        crs[4] = new CollegeCourse("COS 226", "Computer Science", 3.27, 4.03, 3.88, 3.70, 3.58);
        
        Comparator<CollegeCourse> lecComp = CollegeCourse.byLectureRating();
        Arrays.sort(crs, lecComp);
        
        for (int i = 0; i < crs.length; i++)
        {
            StdOut.println(crs[i]);
        }
        
        StdOut.println();
        Arrays.sort(crs);
        
        for (int i = 0; i < crs.length; i++)
        {
            StdOut.println(crs[i]);
        }
        
        CourseSorter sorter = new CourseSorter(crs);
        CollegeCourse[] crsAAS = sorter.allCoursesInDept("African American Studies");
        StdOut.println();
        
        for (int i = 0; i < crsAAS.length; i++)
        {
            StdOut.println(crsAAS[i]);
        }

        */
        
        
        int size = StdIn.readInt();
        CollegeCourse[] courseArray = new CollegeCourse[size];
        
        String nameTemp;
        String deptTemp;
        String lec;
        double lecTemp;
        String prec;
        double precTemp;
        String read;
        double readTemp;
        String pap;
        double papTemp;
        String overall;
        double overallTemp;
        
        for (int i = 0; i < size; i++)
        {
            nameTemp = StdIn.readString();
            deptTemp = StdIn.readString();
            lec = StdIn.readString();
            prec = StdIn.readString();
            read = StdIn.readString();
            pap = StdIn.readString();
            overall = StdIn.readString();         
            
            lecTemp = Double.parseDouble(lec.substring(3, 7));
            precTemp = Double.parseDouble(prec.substring(3, 7));
            readTemp = Double.parseDouble(read.substring(3, 7));
            papTemp = Double.parseDouble(pap.substring(3, 7));
            overallTemp = Double.parseDouble(overall.substring(3, 7));
                
            courseArray[i] = new CollegeCourse(nameTemp, deptTemp, lecTemp, precTemp, readTemp, papTemp, overallTemp);
        }
        
        CourseSorter sorter = new CourseSorter(courseArray);
        
        Comparator<CollegeCourse> deptComparison = CollegeCourse.byDepartmentOrder();
        /*
        StdOut.println(courseArray[2]);
        StdOut.println(BinarySearchCourses.firstIndexOfDept(courseArray, "Architecture", deptComparison));
        StdOut.println(BinarySearchCourses.lastIndexOfDept(courseArray, "Architecture", deptComparison));
        */
       
        CollegeCourse[] econCourses = sorter.allCoursesInDept("Economics");
        
        //StdOut.println(BinarySearchCourses.firstIndexOfDept(courseArray, 
                                                            //"African_American_Studies", deptComparison));
        //StdOut.println(BinarySearchCourses.lastIndexOfDept(courseArray, 
                                                            //"African_American_Studies", deptComparison));
        
        Arrays.sort(econCourses);
        
        for (int i = 0; i < econCourses.length; i++)
        {
            StdOut.println(econCourses[i]);
        }
        
        StdOut.println();
        Comparator<CollegeCourse> lecComp = CollegeCourse.byLectureRating();
        
        Arrays.sort(econCourses, lecComp);
        
        for (int i = 0; i < econCourses.length; i++)
        {
            StdOut.println(econCourses[i]);
        }
        
            
    }
    
}
