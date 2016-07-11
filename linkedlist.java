package employeentries1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;



public class LinkedListModelex {
public static void main (String[]args)
{
	LinkedList<Empl> list=new LinkedList<Empl>();
	
	list.add (new Empl("shiva  ",11));
	list.add (new Empl("dinesh ",1100));
	list.add (new Empl("shiva22  ",1600));
	list.add (new Empl("dinesh33  ",1300));
	
	Collections.sort(list,new MySalaryComp());
	System.out.println("sortedlist");
	for(Empl e:list)
	{
		System.out.println(e);
		
	}
	
}
	
}

class MySalaryComp implements Comparator<Empl>
{
	public int  compare(Empl e1,Empl e2)
	{
	   if(e1.getSalary()<e2.getSalary())
	   {
		   return 1;
		   
	   }
	   else
	   {
		   return -1;
		   
	   }
	} 
}

	class Empl
	{
		private String name;
		private int salary;
		
		public Empl(String n,int s)
		{
			this.name=n;
			this.salary=s;
			
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public int getSalary()
		{
			return salary;
		}

		public void setSalary(int salary )
		{
			this.salary = salary;
		}
		
		
		public String toString()
		{
			return "Name: " +this.name+"salary: " +this.salary;
		}
		
	}


