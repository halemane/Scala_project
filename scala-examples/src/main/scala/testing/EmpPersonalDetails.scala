package testing

/**
  * Created by sumanth on 12/10/2017.
  */
trait EmpPersonalDetails {
  val empId:Int
  val empName : String
  val empAddress : String
  val empDesignation : String
  def displayEmpPersonalDetails = {
    println(s"employee id : $empId, name : $empName, address : $empAddress, role : $empDesignation")
  }
}

abstract class SalaryDetails(val empId:Int,
                             val basicSal:Float,
                             val hra:Float,
                             val deductions:Float) {
  def computeNetSalary = basicSal - hra - deductions
  def computeBonus:Float
}

class Employee(bonusFactor:Float,name:String, address:String, role:String, id:Int, bSal:Float,hra:Float,deductions:Float)
  extends SalaryDetails(id, bSal, hra, deductions) with EmpPersonalDetails{
  override val empId:Int = id
  override val empName: String = name
  override val empAddress: String = address
  override val empDesignation: String = role
  def computeBonus:Float = bonusFactor * basicSal

}

object AbstractnTrailExample extends App {
  val e1 = new Employee(0.5f,"arjun","bangalore","SE",1,
    2500.00f,400.00f,100.00f)
  e1.displayEmpPersonalDetails
  println(s"empid : ${e1.empId}, netsalary : ${e1.computeNetSalary}, bonus : ${e1.computeBonus}")
}
