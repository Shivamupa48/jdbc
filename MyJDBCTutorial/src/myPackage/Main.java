package myPackage;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setupDatabaseAndTable();  // create DB + table
//        student.insertData();             // insert one record
//        student.readData();               // read all records
//        student.updateData(1, "updated@gmail.com"); // update record with id=1
//        student.readData();               // read again to show changes
//        student.deleteData(1);            // delete record with id=1
//        student.readData();               // final read
    }
}
