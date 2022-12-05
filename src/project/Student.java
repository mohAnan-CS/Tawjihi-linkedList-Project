package project;

public class Student {

    private long seatNum;
    private String branch;
    private double grade;

    public Student(long seatNum, String branch, double grade) {
        this.seatNum = seatNum;
        this.branch = branch;
        this.grade = grade;
    }

    public Student() {

    }

    public long getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(long seatNum) {
        this.seatNum = seatNum;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "{" +
                "seatNum=" + seatNum +
                ", branch='" + branch + '\'' +
                ", grade=" + grade +
                '}';
    }
}
