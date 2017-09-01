import java.util.Comparator;
import java.util.Arrays;

public class CollegeCourse implements Comparable<CollegeCourse>
{
    private String courseName; // abbreviation given by pton
    private double lectureRating;
    private double preceptRating;
    private double readingRating;
    private double papersRating;
    private double overallRating; // overall rating from recal.io
    private String department; // department course is affiliated with (ex: Psychology) 
    
    
    public CollegeCourse(String name, String dept, double lecRating, double precRating, 
                         double readRating, double paperRating, double ovRating)
    {
        courseName = name;
        department = dept;
        lectureRating = lecRating;
        preceptRating = precRating;
        readingRating = readRating;
        papersRating = paperRating;
        overallRating = ovRating;
    }
    
    // default sorting is overall ratings from highest to lowest
    public int compareTo(CollegeCourse that)
    {
        return (int)((that.overallRating - this.overallRating) * 10000);
    }
    
    public String getDepartment()
    {
        return department;
    }
    
    public String toString()
    {
        String str;
        str = this.courseName + "\t" + this.department + "\t" + overallRating;
        return str;
    }
    
    public static Comparator<CollegeCourse> byDepartmentOrder()
    {
        return new DepartmentOrderComparison();
    }
    
    public static Comparator<CollegeCourse> byLectureRating()
    {
        return new LectureRatingComparison();
    }
    
    public static Comparator<CollegeCourse> byPreceptRating()
    {
        return new PreceptRatingComparison();
    }
    
    public static Comparator<CollegeCourse> byReadingRating()
    {
        return new ReadingRatingComparison();
    }
    
    public static Comparator<CollegeCourse> byPaperRating()
    {
        return new PaperRatingComparison();
    }
    
    
    private static class DepartmentOrderComparison implements Comparator<CollegeCourse>
    {
        public int compare(CollegeCourse c1, CollegeCourse c2)
        {
            return c1.department.compareTo(c2.department); 
        }
    }
    
    private static class LectureRatingComparison implements Comparator<CollegeCourse>
    {
        public int compare(CollegeCourse c1, CollegeCourse c2)
        {
            return (int)((c2.lectureRating - c1.lectureRating) * 10000); 
        }
    }
    
    private static class PreceptRatingComparison implements Comparator<CollegeCourse>
    {
        public int compare(CollegeCourse c1, CollegeCourse c2)
        {
            return (int)((c2.preceptRating - c1.preceptRating) * 10000); 
        }
    }      
    
    
    private static class ReadingRatingComparison implements Comparator<CollegeCourse>
    {
        public int compare(CollegeCourse c1, CollegeCourse c2)
        {
            return (int)((c2.overallRating - c1.overallRating) * 10000); 
        }
    }    
    
    private static class PaperRatingComparison implements Comparator<CollegeCourse>
    {
        public int compare(CollegeCourse c1, CollegeCourse c2)
        {
            return (int)((c2.overallRating - c1.overallRating) * 10000); 
        }
    }    
    
    
}