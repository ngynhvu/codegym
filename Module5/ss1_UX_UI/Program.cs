
DateTime d1 = DateTime.Now;
DateTime d2 = new DateTime(2023,2,16);
int result = DateTime.Compare(d1,d2);
string relationship;
if (result < 0)
   relationship = "is earlier than";
else if (result == 0)
   relationship = "is the same time as";         
else
   relationship = "is later than";
 
Console.WriteLine("{0} {1} {2}", d1, relationship, d2);
