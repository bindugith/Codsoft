import java.util.Scanner;
public class grade_calculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of subjects:");
        int numSubject = sc.nextInt();
        double totalMarks = 0;
        for(int i=1;i<=numSubject;i++){
            System.out.print("Enter the marks obtain in subject"+ i +":");
            double marks = sc.nextDouble();
            totalMarks+=marks;
        }
        double average_percentage = totalMarks / numSubject;
        System.out.println("The total marks secured:"+totalMarks);
        System.out.println("The average percentage is:"+average_percentage);
        System.out.println("The grade secured:"+calculateGrade(average_percentage));
    }
    public static String calculateGrade(double average_percentage){
        if(average_percentage>=90){
            return "A+";
        }
        else if(average_percentage>=80){
            return "A";
        }
        else if(average_percentage>=70){
            return "B";
        }
        else if(average_percentage>=60){
            return "C";
        }
        else if(average_percentage>=50){
        return "D";
        }
        else{
            return "F";
        }
    }
}