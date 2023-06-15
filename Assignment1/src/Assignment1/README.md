<div align="justify">
Consider you are a company who are helping parents choose the right school for their kids. Find the best schools based on sports events, cultural events, fees, and teacher feedback. In
order to achieve this we need to perform the following.
  
1.Create a POJO object in which represents parents or any person who is trying to search for a good school 
  Name, phoneno, email
  
2.Create a POJO object which has the following information. 
  Schoolname, schoolcode, schoolphoneno, totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, totalteacherappreciation
  Also have an excel file and .arff file which can have the above data for testing purpose
  
3.Create an JAVA program which takes the sort by - totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, 
  totalteacherappreciation And sort direction -ascending or descending. If the user does not provide one of the sort by then throw a custom exception
  SchoolSortByCriteriaNotMetException
  
4.Create a JAVA program to group the schools into
 Good
 Medium
 OK
 This grouping must be based on the parameters totalsportseventsperyear, totalcultureventsperyear, averageannualfee, totalteachercomplaints, totalteacherappreciation

5. Create a program which generates 3 PDFs, 1 PDF containing Good Schools, 2nd PDF containing Medium Schools and 3rd PDF containing OK schools. 
   During generation of PDF make sure there are 3 threads used should not be a single thread 
 </div>
